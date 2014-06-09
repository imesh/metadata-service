package org.imesh.data;

import org.imesh.domain.Property;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by imesh on 6/9/14.
 */
public class Database {
    private Map<String, Map<String, Property>> metaData;

    private static Database instance = null;

    private Database() {
        metaData = new HashMap<String, Map<String, Property>>();
    }

    public static synchronized Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    public Map<String, Map<String, Property>> getMetaData() {
        return metaData;
    }
}