{
    com.badlogic.gdx.graphics.Color: {
            white: { r: 1, g: 1, b: 1, a: 1 },
            red: { r: 1, g: 0, b: 0, a: 1 },
            yellow: { r: 0.5, g: 0.5, b: 0, a: 1 },
    },
    com.badlogic.gdx.graphics.g2d.BitmapFont: {
            medium: { file: default.fnt }
    },
    com.badlogic.gdx.scenes.scene2d.ui.TextButton$TextButtonStyle: {
            default: {
                    down: button, up: button,
                    font: medium, fontColor: white
            },
            green: {
                    down: button, up: button,
                    font: medium, fontColor: { r: 0, g: 1, b: 0, a: 1 }
            }
    }