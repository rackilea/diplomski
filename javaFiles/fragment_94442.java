create table BenefitDetails_PriceDiscount (
        map_id integer PRIMARY KEY,
        ... /* any other attributes, perhaps? */
        FOREIGN KEY (map_id) references Promo_Benefit(map_id)
);

create table BenefitDetails_PriceDiscount_Map (
        map_id integer references Promo_Benefit(map_id),
        plan_id integer references Plans(plan_id),
        reduced_price numeric not null,
        PRIMARY KEY (map_id, plan_id)
        FOREIGN KEY (map_id) references Promo_Benefit(map_id)
);