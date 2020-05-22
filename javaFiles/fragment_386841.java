Element petsWrapper = document.selectFirst(".pets");
Elements pets = petsWrapper.select(".pet");
// select middle element
Element middleElement = petsWrapper.selectFirst(".friends-pets");
// remove from "pets" every element that comes after the middle element
pets.removeAll(middleElement.nextElementSiblings());
System.out.println(pets);