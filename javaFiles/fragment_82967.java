switch (formatter.getFillDirection()) {
            case FILL:
                path.lineTo(lastPoint.x, lastPoint.y);
                path.close();
                break;
            default:
                throw new UnsupportedOperationException(
                        "Fill direction not yet implemented: " + formatter.getFillDirection());
        }