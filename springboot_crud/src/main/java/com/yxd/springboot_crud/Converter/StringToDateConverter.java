package com.yxd.springboot_crud.Converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StringToDateConverter implements Converter<String, Date> {
    private static final String dataFormat = "yyyy-MM-dd HH:mm:ss";
    private static final String shortDataFormat = "yyyy-MM-dd";


    @Override
    public Date convert(String s) {
        if(StringUtils.isEmpty(s))
            return null;
        s=s.trim();
        try{
            if(s.contains("-")){
                SimpleDateFormat formatter;
                if(s.contains(":"))
                    formatter = new SimpleDateFormat(dataFormat);
                else
                    formatter = new SimpleDateFormat(shortDataFormat);
                Date dtDate = formatter.parse(s);
                return dtDate;

            }else if(s.matches("^\\d+$")){
                Long lTime = new Long(s);
                return new Date(lTime);
            }
        }catch (Exception e){
            throw new RuntimeException(String.format("parse %s to Date fail",s));


        }

            throw new RuntimeException(String.format("parse %s to Date fail",s));




    }
}
