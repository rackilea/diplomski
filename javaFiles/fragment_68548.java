package stackoverflow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.annotation.Nullable;

public class TableDTO {
  private final String countryName;
  private final String sourceName;
  private final int year;
  @Nullable
  private final Double usageValue;
  private final Double powerUsers;

  public TableDTO(final String countryName, final String sourceName, final int year, final Double usageValue,
      final Double powerUsers) {
    this.countryName = countryName;
    this.sourceName = sourceName;
    this.year = year;
    this.usageValue = usageValue;
    this.powerUsers = powerUsers;
  }

  public String getCountryName() {return countryName;}
  public String getSourceName() {return sourceName;}
  public int getYear() {return year;}
  @Nullable public Double getUsageValue() {return usageValue;}
  public Double getPowerUsers() {return powerUsers;}

  @Override
  public String toString() {
    return "TableDTO [countryName=" + countryName + ", sourceName=" + sourceName + ", year=" + year + ", usageValue="
        + usageValue + ", powerUsers=" + powerUsers + "]";
  }

  public static void main(final String[] args) {

    final java.util.Map<String, java.util.List<TableDTO>> data = new LinkedHashMap<>();

    final List<TableDTO> chrome = new ArrayList<>();
    chrome.add(new TableDTO("UK", "Lorem", 2013, 2.90, 5.4));
    chrome.add(new TableDTO("US", "Lorem", 2013, 4.10, 1.5));
    chrome.add(new TableDTO("EU", "Lorem", 2013, 1.20, 0.22));
    chrome.add(new TableDTO("Asia", "Lorem", 2013, 3.90, -1.10));
    data.put("Chrome", chrome);

    final List<TableDTO> ie = new ArrayList<>();
    ie.add(new TableDTO("UK", "Lorem", 2013, 1.40, 24.4));
    ie.add(new TableDTO("US", "Lorem", 2013, 0.90, 14.4));
    ie.add(new TableDTO("EU", "Lorem", 2013, 2.10, 0.));
    ie.add(new TableDTO("Asia", "Lorem", 2013, 0.90, 0.4));
    data.put("IE", ie);

    final List<TableDTO> fx = new ArrayList<>();
    fx.add(new TableDTO("UK", "Lorem", 2013, 0.10, 2.14));
    fx.add(new TableDTO("US", "Lorem", 2013, 1.10, 4.0));
    fx.add(new TableDTO("EU", "Lorem", 2013, null, 4.4));
    fx.add(new TableDTO("Asia", "Lorem", 2013, 2.90, 4.4));
    data.put("FX", fx);

    data.values()
        .stream()
        .flatMap(List::stream)
        .collect(Collectors.groupingBy(dto -> Arrays.asList(dto.getCountryName(), dto.getSourceName(), dto.getYear())))
        .values()
        .stream()
        .filter(list -> list.stream().map(TableDTO::getUsageValue).noneMatch(Objects::isNull))
        .map(
            values -> {
              final TableDTO root = values.iterator().next();

              final double usageValueAvg = values.stream().map(TableDTO::getUsageValue).filter(Objects::nonNull)
                  .collect(Collectors.averagingDouble(Double::doubleValue));
              final double powerUsersAvg = values.stream().map(TableDTO::getPowerUsers)
                  .collect(Collectors.averagingDouble(Double::doubleValue));

              return new TableDTO(root.getCountryName(), root.getSourceName(), root.getYear(), usageValueAvg,
                  powerUsersAvg);

            }).forEach(System.out::println);
    ;

  }
}