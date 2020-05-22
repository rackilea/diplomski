if(null != jdbcTemplate) {
            // Performing The Sql 'Insert' Operation
            String sql = "insert into patient(id_patient, description) values(?,?);" +
                    "insert into attachment(id_data, file_data, patientID) values (?, ?, (select patientID from patient where patientID = id_patient));";


            jdbcTemplate.update(sql, patient.getDescription(), attachment.getId_data(), attachment.getData(), attachment.getPatientID());