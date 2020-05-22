jsize size = env->GetArrayLength( arr );
std::vector<double> input( size );
env->GetDoubleArrayRegion( arr, 0, size, &input[0] );

//  ...

jdoubleArray output = env->NewDoubleArray( results.size() );
env->SetDoubleArrayRegion( output, 0, results.size(), &results[0] );