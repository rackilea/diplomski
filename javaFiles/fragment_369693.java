@GetMapping("/car")
public String carForm(Model model) {
    model.addAttribute("car", new Car());
    model.addAttribute("cars", carService.getAllCars());
    return "car";
}