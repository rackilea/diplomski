public void init(GLAutoDrawable drawable) {
    GL4 gl4 = drawable.getGL().getGL4();

    gl4.glDisable(GL4.GL_DEPTH_TEST);
    gl4.glEnable(GL4.GL_CULL_FACE);
    gl4.glCullFace(GL4.GL_BACK);
    buildScreenVAO(gl4);

    FloatBuffer pixelBuffer = GLBuffers.newDirectFloatBuffer(width * height * 4);
    this.textureIndex = GLUtils.initTexture(gl4, width, height, pixelBuffer);
    this.samplerIndex = GLUtils.initSimpleSampler(gl4);

    if (clContext == null) {
        try {
            gl4.glFinish();
            this.clContext = CLGLContext.create(gl4.getContext());
            this.clDevice = clContext.getMaxFlopsDevice();
            //if (device.getExtensions().contains("cl_khr_gl_sharing"))
            this.clCommandQueue = clDevice.createCommandQueue();

            this.clProgram = clContext.createProgram(new FileInputStream(new File(ResourceLocator.getInstance().kernelsPath + "raytracer.cl"))).build(); // load sources, create and build program
            this.clKernel = clProgram.createCLKernel("main");

            this.clTexture = (CLGLTexture2d<FloatBuffer>) clContext.createFromGLTexture2d(GL4.GL_TEXTURE_2D, textureIndex, 0, Mem.WRITE_ONLY);
            this.viewTransform = clContext.createFloatBuffer(16 * 4, Mem.READ_ONLY);
            this.w = clContext.createFloatBuffer(1, Mem.READ_ONLY);

            clKernel.putArg(clTexture).putArg(width).putArg(height).putArg(viewTransform).putArg(w);
            fillViewTransform(viewTransform);
            fillW(w);

            clCommandQueue.putWriteBuffer(viewTransform, false);
            clCommandQueue.putWriteBuffer(w, false);
            clCommandQueue.putAcquireGLObject(clTexture);
            clCommandQueue.put1DRangeKernel(clKernel, 0, width * height, 0);
            clCommandQueue.putReleaseGLObject(clTexture);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    buildShaderProgram(gl4);
    bindObjects(gl4); 
}