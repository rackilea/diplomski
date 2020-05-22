interface BaseDAO {//declare all the CRUD methods}

interface PersonaDAO extends BaseDAO {//declare all Person related methods like getPersonsList}

class BaseDAOImpl implements BaseDAO {//CRUD method implementations }

class PersonaDAOImpl extends BaseDAOImpl implements PersonDAO {//implementation of Person related methods}