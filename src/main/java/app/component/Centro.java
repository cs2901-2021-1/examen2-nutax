package app.component;

import java.util.HashMap;

public record Centro(HashMap<String, Integer> completos, HashMap<String, Integer> parciales, Boolean activo) {
}
