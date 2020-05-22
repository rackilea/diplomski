function getCooldownTime(distance) {
    const
        data = [{ distance: 1, cooldown: 1 }, { distance: 3, cooldown: 2 }, { distance: 7, cooldown: 5 }, { distance: 10, cooldown: 7 }, { distance: 12, cooldown: 8 }, { distance: 18, cooldown: 10 }, { distance: 30, cooldown: 15 }, { distance: 65, cooldown: 22 }, { distance: 81, cooldown: 25 }, { distance: 250, cooldown: 45 }, { distance: 500, cooldown: 60 }, { distance: 700, cooldown: 85 }, { distance: 1000, cooldown: 90 }, { distance: 1500, cooldown: 120 }],
        cooldown = (data.find(o => distance <= o.distance) || {}).cooldown;

    return cooldown >= 60 ? (cooldown / 60) + ' hr' : cooldown + ' min';
}

console.log(getCooldownTime(0));
console.log(getCooldownTime(1));
console.log(getCooldownTime(2));
console.log(getCooldownTime(10));
console.log(getCooldownTime(100));
console.log(getCooldownTime(1000));