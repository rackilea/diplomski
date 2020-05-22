interface Sprite { ... }
class StaticSprite implements Sprite { ... }
class AnimatedSprite implements Sprite { ... }

class PhysicalSprite implements Sprite, Physics {
    PhysicalSprite(Sprite inner) { ... }
    ...
}