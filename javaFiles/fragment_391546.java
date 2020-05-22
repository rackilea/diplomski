Matrix.setIdentityM(_model_matrix, 0);

Matrix.setRotateM(_rotation_x_matrix, 0, _angles.getX(), 1, 0, 0);
Matrix.setRotateM(_rotation_y_matrix, 0, _angles.getY(), 0, 1, 0);
Matrix.setRotateM(_rotation_z_matrix, 0, _angles.getZ(), 0, 0, 1);
Matrix.multiplyMM(_model_matrix, 0, _rotation_x_matrix, 0, _model_matrix, 0);
Matrix.multiplyMM(_model_matrix, 0, _rotation_y_matrix, 0, _model_matrix, 0);
Matrix.multiplyMM(_model_matrix, 0, _rotation_z_matrix, 0, _model_matrix, 0);

Matrix.multiplyMM(_modelview_matrix, 0, _view_matrix, 0, _model_matrix, 0);
Matrix.multiplyMM(_modelviewprojection_matrix, 0, _projection_matrix, 0, _modelview_matrix, 0);