String vertexShader = "attribute vec4 a_position;\n" +
                "attribute vec4 a_color;\n" +
                "attribute vec2 a_texCoord0;\n" +
                "\n" +
                "uniform mat4 u_projTrans;\n" +
                "\n" +
                "varying vec4 v_color;\n" +
                "varying vec2 v_texCoords;\n" +
                "\n" +
                "void main() {\n" +
                "    v_color = a_color;\n" +
                "    v_texCoords = a_texCoord0;\n" +
                "    gl_Position = u_projTrans * a_position;\n" +
                "}";

        String fragmentShader = "#ifdef GL_ES\n" +
                "precision mediump float;\n" +
                "#endif\n" +
                "\n" +
                "varying vec4 v_color;\n" +
                "varying vec2 v_texCoords;\n" +
                "uniform sampler2D u_texture;\n" +
                "uniform mat4 u_projTrans;\n" +
                "\n" +
                "void main() {\n" +
                "       vec4 color = v_color * texture2D( u_texture, v_texCoords );\n" +
                "       if( color.a == 0.0 ) gl_FragColor = vec4( color.r, color.g, color.b, 0.0 );\n" +
                "       else gl_FragColor = vec4( 1.0, 1.0, 1.0, 1.0 );" +
                "}";

        ShaderProgram shaderProgram = new ShaderProgram(vertexShader,fragmentShader);

        public void render() {
            Gdx.gl.glClearColor(0, 0, 0, 1);
            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

            batch.begin();
            batch.setShader(shaderProgram);
            batch.draw(texture, x, y, width, height);
            batch.end();

        }