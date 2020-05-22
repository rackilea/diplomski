package io.sciro.leaderdata.repo;

import io.sciro.leaderdata.domain.Match;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(path = "match", collectionResourceRel = "match")
public interface MatchRepo extends Neo4jRepository<Match, Long> {

    Match findOneByCodeName(String codeName);

    Iterable<Match> findAllByCodeName(@Param("codeName")  String codeName);
}