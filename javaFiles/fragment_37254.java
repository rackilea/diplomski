protected void onDraw(Canvas canvas) {
        ballBounds.set(ballX - ballRadius, ballY - ballRadius, ballX + ballRadius, ballY + ballRadius);
        Handler handler = new Handler();
        int rnd = (int) (Math.random() * 4);
        handler.postDelayed(new Runnable() {
            public void run() {
                switch (rnd) {
                    case 0:
                        paint.setColor(Color.BLUE);
                        break;

                    case 1:
                        paint.setColor(Color.RED);
                        break;

                    case 2:
                        paint.setColor(Color.GREEN);
                        break;

                    case 3:
                        paint.setColor(Color.YELLOW);
                        break;
                }
            }
        }, 3000);
        canvas.drawOval(ballBounds, paint);
        update();
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
        }
        invalidate();
    }