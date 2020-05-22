if (day >= 1 && day <= 5) {
  if (vacation) {
      return "10:00";
  } else {
      return "7:00";
  }
} else {
  if (vacation) {
      return "off";
  } else {
      return "10:00";
  }
}