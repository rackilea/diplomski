getUserResult.map(user -> user.id).subscribe(
        id -> { Log.d("Stream 1", "id = " + id); }
);

getUserResult.map(user -> user.login).subscribe(
        login -> { Log.d("Stream 2", "login = " + login); }
);