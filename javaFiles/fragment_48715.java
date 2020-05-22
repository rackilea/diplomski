if (card.getThisYear() > card.getExpYear()) {
        card.setActive(false);
    }
    if (card.getThisYear() == card.getExpYear()) {
        if (card.getThisMonth() > card.getExpMonth()) {
            card.setActive(false);
        }
    }
    if (card.getThisYear() == card.getExpYear()) {
        if (card.getThisMonth() == card.getExpMonth()) {
            if (card.getThisDay() > card.getExpDay()) {
                card.setActive(false);
            }
        }
    } else
        card.setActive(true);

    card.testing();
}