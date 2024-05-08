package com.itheima.a23.sub;

import org.springframework.core.GenericTypeResolver;
import org.springframework.core.ResolvableType;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class TestGenericType {
    public static void main(String[] args) {
        // 小技巧
        // 1. java api
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>");
        Type type = TeacherDao.class.getGenericSuperclass();
        System.out.println(type);

        if (type instanceof ParameterizedType parameterizedType) {  // 检查是否确实带有泛型信息
            System.out.println(parameterizedType.getActualTypeArguments()[0]);
        }

        // 2. spring api 1 相当于对java api做了封装
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>");
        Class<?> t = GenericTypeResolver.resolveTypeArgument(TeacherDao.class, BaseDao.class);
        System.out.println(t);

        // 3. spring api 2
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println(ResolvableType.forClass(TeacherDao.class).getSuperType().getGeneric().resolve());
    }

}
