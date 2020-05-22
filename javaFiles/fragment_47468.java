public void setKoers(double koers) throws NegativeValueException {
    if (koers > 0 ) {
            this.koers=koers;
        } else {
            throw new NegativeValueException("negative number");
        }
}

try{
    cal.setKoers( Double.parseDouble(args[0]));

    } catch(NegativeValueException e) {
        System.out.println(e.getMessage());
    } catch (NumberFormatException e) {
        System.out.println( e.getMessage());
    }