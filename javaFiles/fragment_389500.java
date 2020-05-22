List<Rates> rates = new ArrayList<>();
rates.add(new Rates("إيه رأيك في البني آدم اللي شرح الدورة"));
rates.add(new Rates("ايه رأيك في المكان اللي تمت فيه الدورة");
rates.add(new Rates("الجهة المنظمة اللي عملت الدورة"));
rates.add(new Rates("محتوى الدورة"));
rates.add(new Rates("تقييم عام"));
List<String> strings = new ArrayList<>(rates.size());
for (Rate rate : rates) {
    strings.add(rate != null ? rate.getTitle() : null);
}

//Initialization of Adapter and ListView and hooking them together
RateAdapter rateAdapter = new RateAdapter(this , titlesArray);