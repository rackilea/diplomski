class InsertJogosCSV {
    def main(args: Array[String]) {
        val dao = new DAO()
        val application = FakeApplication()

        def insertJogos(csv: CSV)(implicit s: Session) = {....}

        ....
    }
}