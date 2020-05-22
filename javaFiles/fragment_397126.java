Observable.create(new Observable.OnSubscribe<String>() {
        @Override
        public void call(Subscriber<? super String> subscriber) {
            subscriber.onNext("imageUrl");
        }
    }).flatMap(new Func1<String, Observable<Bitmap>>() {
        @Override
        public Observable<Bitmap> call(String imageUrl) {
            return getBitmapAsync(imageUrl);
        }
    }).subscribe(new Action1<Bitmap>() {
        @Override
        public void call(Bitmap o) {
            imageView.setImageBitmap(image);
        }
    });