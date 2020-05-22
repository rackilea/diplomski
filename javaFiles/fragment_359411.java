public class JobClassConverter implements AttributeConverter<JobClass, Integer> {

    @Override
    public Integer convertToDatabaseColumn(final JobClass pAttribute) {
        if (pAttribute == null) {
            return null;
        } else {
            switch (pAttribute) {
                case HOURLY:
                    return 1;
                case SALARY:
                    return 2;
                case EXECUTIVE:
                    return 3;
            }
        }
    }

    @Override
    public JobClass convertToEntityAttribute(final Integer pDbData) {
        if (pDbData == null) {
            return null;
        } else {
            switch (pDbData) {
                case 1:
                    return JobClass.HOURLY;
                case 2:
                    return JobClass.SALARY;
                case 3:
                    return JobClass.EXECUTIVE;
            }
        }
    }
}