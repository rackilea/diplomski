package com.programsji.converter;

    import org.springframework.core.convert.converter.Converter;

    import com.programsji.bo.Hobby;

    public class StringToHobbyConverter implements Converter<String, Hobby> {

        @Override
        public Hobby convert(String str) {
            // I Am Using Fix Hobbies Here, You Can Add Your Own Method to Get
            // Hobbies By ID
            Hobby hobby = null;
            if (str.equals("1")) {
                hobby = new Hobby(1, "First Hobby");
            } else if (str.equals("2")) {
                hobby = new Hobby(2, "Second Hobby");
            }
            return hobby;
        }

    }