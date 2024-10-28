package nava.avaliation.nava;

import com.fasterxml.jackson.core.JsonProcessingException;

public class ObjectParser {

    public static String stringify(Object o) {
        try {
            return CepComponent.objectMapper().writeValueAsString(o);
        } catch (JsonProcessingException e) {
            return "";
        }
    }

    public static <T> T parser(Object o, Class oClass) {
        return (T) CepComponent.objectMapper().convertValue(o, oClass);
    }

    public static <T> T reader(String string, Class oClass) {
        try {
            return (T) CepComponent.objectMapper().readValue(string, oClass);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
