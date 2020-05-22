%include "std_map.i"

// 1.
%typemap(javaout) cv::Mat, cv::Mat& {
    return new org.opencv.core.Mat($jnicall);
}

...

// 2.
%ignore std::map<std::string, std::shared_ptr<cv::Mat>>::get;

// 3.
%template(Map_String_Shared_ptr_Mat) std::map<std::string, std::shared_ptr<cv::Mat>>;

// 4.
%extend std::map<std::string, std::shared_ptr<cv::Mat>>{
    const cv::Mat& getPlain(const std::string& key) throw (std::out_of_range) {
        std::map<std::string,std::shared_ptr< cv::Mat > >::iterator i = self->find(key);
        if (i != self->end())
            return *i->second;
        else
            throw std::out_of_range("key not found");
    }
}