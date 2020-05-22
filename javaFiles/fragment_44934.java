package org.sachmo.hooktale.db;

import org.sachmo.hooktale.core.Angler;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

/**
 * Created by jason on 5/27/14.
 * angler mapper
 */
public class AnglerMapper implements ResultSetMapper<Angler> {
  @Override
  public Angler map(int i, ResultSet rs, StatementContext statementContext) throws     SQLException {
    return new Angler((UUID)rs.getObject("angler_id"), rs.getString("first_name"),
            rs.getString("last_name"), rs.getString("email"), rs.getString("password"));
  }
}