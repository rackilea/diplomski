import java.io.BufferedReader;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.jdbc.datasource.init.UncategorizedScriptException;
import org.springframework.util.StringUtils;

/**
 * Populates, initializes, or cleans up a database using SQL scripts defined in
 * external resources.
 * <p>
 * This implementation will clean up a given script by removing comments and processing instructions
 * contained in the script and perform a table reordering based on defined foreign keys in a
 * best-effort attempt.
 *
 * <ul>
 * <li>Call {@link #addScript} to add a single SQL script location.
 * <li>Call {@link #addScripts} to add multiple SQL script locations.
 * <li>Consult the setter methods in this class for further configuration options.
 * <li>Call {@link #populate} or {@link #execute} to initialize or clean up the
 * database using the configured scripts.
 * </ul>
 *
 * @author Keith Donald
 * @author Dave Syer
 * @author Juergen Hoeller
 * @author Chris Beams
 * @author Oliver Gierke
 * @author Sam Brannen
 * @author Chris Baldwin
 * @author Roman Vottner
 *
 * @since 3.0
 * @see DatabasePopulatorUtils
 * @see ScriptUtils
 */
public class OrderedResourceDatabasePopulator extends ResourceDatabasePopulator {

  private static final Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

  protected String sqlScriptEncoding;

  /**
   * Construct a new {@code OrderedResourceDatabasePopulator} with default settings.
   */
  public OrderedResourceDatabasePopulator() {
    /* no-op */
  }

  /**
   * Construct a new {@code OrderedResourceDatabasePopulator} with default settings
   * for the supplied scripts.
   * 
   * @param scripts the scripts to execute to initialize or clean up the database
   *                (never {@code null})
   */
  public OrderedResourceDatabasePopulator(Resource... scripts) {
    this();
    setScripts(cleanResource(scripts));
  }

  /**
   * Construct a new {@code OrderedResourceDatabasePopulator} with the supplied values.
   *
   * @param continueOnError flag to indicate that all failures in SQL should be logged but not cause
   *                        a failure
   * @param ignoreFailedDrops flag to indicate that a failed SQL {@code DROP} statement can be
   *                          ignored
   * @param sqlScriptEncoding the encoding for the supplied SQL scripts; may be {@code null} or
   *                           <em>empty</em> to indicate platform encoding
   * @param scripts the scripts to execute to initialize or clean up the database (never {@code
   *                null})
   */
  public OrderedResourceDatabasePopulator(boolean continueOnError, boolean ignoreFailedDrops,
                                          String sqlScriptEncoding, Resource... scripts) {

    super(continueOnError, ignoreFailedDrops, sqlScriptEncoding, scripts);
  }

  /**
   * Add a script to execute to initialize or clean up the database.
   *
   * @param script the path to an SQL script (never {@code null})
   */
  @Override
  public void addScript(Resource script) {
    super.addScript(cleanResource(script)[0]);
  }

  /**
   * Add multiple scripts to execute to initialize or clean up the database.
   * 
   * @param scripts the scripts to execute (never {@code null})
   */
  @Override
  public void addScripts(Resource... scripts) {
    super.addScripts(cleanResource(scripts));
  }

  /**
   * Set the scripts to execute to initialize or clean up the database, replacing any previously 
   * added scripts.
   * 
   * @param scripts the scripts to execute (never {@code null})
   */
  @Override
  public void setScripts(Resource... scripts) {
    super.setScripts(cleanResource(scripts));
  }

  /**
   * Specify the encoding for the configured SQL scripts, if different from the platform encoding.
   * 
   * @param sqlScriptEncoding the encoding used in scripts; may be {@code null} or empty to indicate
   *                          platform encoding
   * 
   * @see #addScript(Resource)
   */
  @Override
  public void setSqlScriptEncoding(String sqlScriptEncoding) {
    super.setSqlScriptEncoding(sqlScriptEncoding);
    this.sqlScriptEncoding = StringUtils.hasText(sqlScriptEncoding) ? sqlScriptEncoding : null;
  }

  private Resource[] cleanResource(Resource... scripts) {
    List<Resource> cleaned = new ArrayList<>();
    for (Resource script : scripts) {
      EncodedResource encodedScript = new EncodedResource(script, this.sqlScriptEncoding);

      StringBuilder sb = new StringBuilder();
      try (BufferedReader in = new BufferedReader(encodedScript.getReader())) {
        String line;

        // parse script
        Map<String, Table> tables = new LinkedHashMap<>();
        Table curTable = null;
        while ((line = in.readLine()) != null) {
          if (!line.startsWith("#") && !line.startsWith("/*")) {
            line = line.replaceAll("`", "");
            String lowerCaseLine = line.toLowerCase();

            // parse table definitions
            if (lowerCaseLine.startsWith("drop table") || "".equals(line.trim())) {
              if (curTable != null) {
                curTable = null;
              }
              continue;
            }

            curTable = parseTable(line, tables, curTable);
          }
        }

        // check the order of table definitions and reorder them to ensure referenced tables are
        // defined before table specifying the foreign key
        Map<String, Table> orderedTables = new LinkedHashMap<>();
        List<Table> backlog = new ArrayList<>();
        for (String tableName : tables.keySet()) {
          // check for available foreign key definitions
          List<String> referencedTables = tables.get(tableName).getReferencedTables();
          // if no foreign keys are defined in the table we can add the table to the current set
          if (referencedTables.isEmpty()) {
            orderedTables.put(tableName, tables.get(tableName));
            processBacklog(backlog, orderedTables);
            continue;
          }

          // foreign keys are defined. If any of the referenced tables is not yet in the set move it
          // to the backlog table and try it later
          boolean dependenciesAvailable = true;
          for (String dependency : referencedTables) {
            if (!orderedTables.containsKey(dependency)) {
              backlog.add(tables.get(tableName));
              dependenciesAvailable = false;
              break;
            }
          }

          // if all referred tables are available in the set add the current table also to the
          // ordered set
          if (dependenciesAvailable) {
            orderedTables.put(tableName, tables.get(tableName));
            processBacklog(backlog, orderedTables);
            continue;
          }

          // probe tables kept in the backlog again
          processBacklog(backlog, orderedTables);
        }

        while (!backlog.isEmpty()) {
          processBacklog(backlog, orderedTables);
        }

        ArrayList<Table> reverse = new ArrayList<>(orderedTables.values());
        ListIterator<Table> reverseIter = reverse.listIterator(reverse.size());
        sb.append("DROP TABLE IF EXISTS ");
        int originalSize = sb.length();
        while (reverseIter.hasPrevious()) {
          if (sb.length() > originalSize) {
            sb.append(", ");
          }
          sb.append(reverseIter.previous().getName());
        }
        sb.append(";\n\n");

        for (Table table : orderedTables.values()) {
          sb.append(table.getCreateStatement()).append("\n");
        }

      } catch (IOException ex) {
        throw new UncategorizedScriptException(ex.getMessage(), ex);
      }

      if (LOG.isTraceEnabled()) {
        LOG.trace("SQL script after cleaning: \n{}", sb.toString());
      }
      Resource cleanedResource = new ByteArrayResource(sb.toString().getBytes());
      cleaned.add(cleanedResource);
    }

    return cleaned.toArray(new Resource[cleaned.size()]);
  }

  private Table parseTable(String line, Map<String, Table> tables, Table curTable) {
    String lowerCaseLine = line.toLowerCase();
    if (lowerCaseLine.startsWith("create table")) {
      String name = line.substring("create table ".length(), line.indexOf("(")).trim();
      curTable = new Table(name);
      tables.put(name, curTable);
    } else if (curTable != null) {
      if (lowerCaseLine.contains("primary key")) {
        curTable.setPrimaryKey(line);
      } else if (lowerCaseLine.contains("unique key")) {
        curTable.addUniqueKey(line);
      } else if (lowerCaseLine.contains("foreign key")) {
        curTable.addForeignKey(line);
      } else if (lowerCaseLine.contains(" key ")) {
        curTable.addIndex(line);
      } else if (lowerCaseLine.contains(" charset=") || lowerCaseLine.contains("engine=")) {
        curTable.setMetaData(line);
      } else {
        curTable.addColumn(line);
      }
    }
    return curTable;
  }

  private void processBacklog(List<Table> backlog, Map<String, Table> orderedTables) {
    Iterator<Table> iter = backlog.iterator();
    while (iter.hasNext()) {
      Table table = iter.next();
      boolean allDependenciesAvailable = true;
      for (String dependency : table.getReferencedTables()) {
        if (!orderedTables.containsKey(dependency)) {
          allDependenciesAvailable = false;
        }

        if (allDependenciesAvailable) {
          orderedTables.put(table.getName(), table);
          iter.remove();
        }
      }
    }
  }

  private class Table {

    private final String name;
    private List<String> columns = new ArrayList<>();
    private String primaryKey;
    private List<String> uniqueKeys = new ArrayList<>();
    private List<String> indices = new ArrayList<>();
    private List<String> foreignKeys = new ArrayList<>();
    private String metaData;

    public Table(String name) {
      this.name = name;
    }

    String getName() {
      return this.name;
    }

    void addColumn(String column) {
      this.columns.add(column);
    }

    void setPrimaryKey(String primaryKey) {
      this.primaryKey = primaryKey;
    }

    void addUniqueKey(String uniqueKey) {
      this.uniqueKeys.add(uniqueKey);
    }

    void addIndex(String index) {
      this.indices.add(index);
    }

    void addForeignKey(String foreignKey) {
      this.foreignKeys.add(foreignKey);
    }

    List<String> getReferencedTables() {
      List<String> referencedTables = new ArrayList<>();
      for (String foreignKey : foreignKeys) {
        int start = foreignKey.toLowerCase().indexOf("references ") + "references ".length();
        String table = foreignKey.substring(start, foreignKey.indexOf(" ", start));
        referencedTables.add(table);
      }
      return referencedTables;
    }

    void setMetaData(String metaData) {
      this.metaData = metaData;
    }

    String getCreateStatement() {
      StringBuilder sb = new StringBuilder();
      sb.append("CREATE TABLE ").append(this.name).append(" (");
      for (String column : this.columns) {
        sb.append("\n");
        sb.append("  ").append(column);
      }
      if (null != primaryKey) {
        sb.append("\n");
        sb.append("  ").append(this.primaryKey);
      }
      if (!uniqueKeys.isEmpty()) {
        for (String uniqueKey : uniqueKeys) {
          sb.append("\n");
          sb.append("  ").append(uniqueKey);
        }
      }
      if (!indices.isEmpty()) {
        for (String index : indices) {
          sb.append("\n");
          sb.append("  ").append(index);
        }
      }
      if (!foreignKeys.isEmpty()) {
        for (String foreignKey : foreignKeys) {
          sb.append("\n");
          sb.append("  ").append(foreignKey);
        }
      }
      sb.append("\n");
      if (metaData == null || !metaData.contains(")")) {
        sb.append(") ");
      }
      if (metaData != null) {
        sb.append(metaData);
      }
      sb.append("\n");

      return sb.toString();
    }
  }
}