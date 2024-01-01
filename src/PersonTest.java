import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class PersonTest {

    @Test
    public void getPersonNamesFieldTest() {

        Object person = new Person();
        Field[] fields = person.getClass().getDeclaredFields();
        Method[] methods = person.getClass().getDeclaredMethods();
        Constructor[] constructors = person.getClass().getDeclaredConstructors();

        List<String> actualFieldName = getFieldNames(fields);
        assertTrue(Arrays.asList("name", "age").containsAll(actualFieldName));


        List<String> actualMethodName = getMethodNames(methods);
        assertTrue(Arrays.asList("save", "delete").containsAll(actualMethodName));

        assertTrue(constructors.length == 2);
    }

    private List<String> getMethodNames(Method[] methods) {
        List<String> methodsNames = new ArrayList<>();
        for (Method method : methods)
            methodsNames.add(method.getName());
        return methodsNames;
    }

    private static List<String> getFieldNames(Field[] fields) {
        List<String> fieldNames = new ArrayList<>();
        for (Field field : fields)
            fieldNames.add(field.getName());
        return fieldNames;
    }
}
