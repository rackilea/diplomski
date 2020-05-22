//Postagem post = new Postagem();

    cursor.moveToFirst();

    while (!cursor.isAfterLast()) {

        Postagem post = new Postagem(); //add this here

        post.setTituloPostagem(cursor.getString(cursor.getColumnIndex("TITULO_POSTAGEM")));
        post.setDataPostagem(cursor.getString(cursor.getColumnIndex("DATA_POSTAGEM")));
        post.setComentarioPostagem(cursor.getString(cursor.getColumnIndex("COMENTARIO_POSTAGEM")));
        post.setCaminhoFoto(cursor.getString(cursor.getColumnIndex("FOTO_POSTAGEM")));
        postagem.add(post);
        cursor.moveToNext();
    }