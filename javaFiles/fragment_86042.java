class MySprite {
    private static final String SPRITE_SHEET_PATH = "http://"
            + "orig12.deviantart.net/7db3/f/2010/338/3/3/"
            + "animated_sprite_sheet_32x32_by_digibody-d3479l2.gif";
    private static final int MAX_MOVING_INDEX = 4;
    private static final int DELTA = 4;
    private SpriteDirection direction;
    private Map<SpriteDirection, Image> standingImgMap = new EnumMap<>(SpriteDirection.class);
    private Map<SpriteDirection, List<Image>> movingImgMap = new EnumMap<>(SpriteDirection.class);
    private int x;
    private int y;
    private boolean moving = false;
    private int movingIndex = 0;

    public MySprite(SpriteDirection direction, int x, int y) throws IOException {
        this.direction = direction;
        this.x = x;
        this.y = y;
        createSprites();
    }

    public void draw(Graphics g) {
        Image img = null;
        if (!moving) {
            img = standingImgMap.get(direction);
        } else {
            img = movingImgMap.get(direction).get(movingIndex);
        }
        g.drawImage(img, x, y, null);
    }

    private void createSprites() throws IOException {
        URL spriteSheetUrl = new URL(SPRITE_SHEET_PATH);
        BufferedImage img = ImageIO.read(spriteSheetUrl);

        // get sub-images (sprites) from the sprite sheet
        // magic numbers for getting sprites from sheet, all obtained by trial and error
        int x0 = 0;
        int y0 = 64;
        int rW = 32;
        int rH = 32;
        for (int row = 0; row < 4; row++) {
            SpriteDirection dir = SpriteDirection.values()[row];
            List<Image> imgList = new ArrayList<>();
            movingImgMap.put(dir, imgList);
            int rY = y0 + row * rH;
            for (int col = 0; col < 5; col++) {
                int rX = x0 + col * rW;
                BufferedImage subImg = img.getSubimage(rX, rY, rW, rH);
                if (col == 0) {
                    // first image is standing
                    standingImgMap.put(dir, subImg);
                } else {
                    // all others are moving
                    imgList.add(subImg);
                }
            }
        }
    }

    public SpriteDirection getDirection() {
        return direction;
    }

    public void setDirection(SpriteDirection direction) {
        if (this.direction != direction) {
            setMoving(false);
        }
        this.direction = direction;

    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
        if (!moving) {
            movingIndex = 0;
        }
    }

    public void tick() {
        if (moving) {
            switch (direction) {
            case RIGHT:
                x += DELTA;
                break;
            case LEFT:
                x -= DELTA;
                break;
            case FORWARD:
                y += DELTA;
                break;
            case AWAY:
                y -= DELTA;
            }
            movingIndex++;
            movingIndex %= MAX_MOVING_INDEX;
        }
    }

    public int getMovingIndex() {
        return movingIndex;
    }

    public void setMovingIndex(int movingIndex) {
        this.movingIndex = movingIndex;
    }

}