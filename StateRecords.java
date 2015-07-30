package StateDetails;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by test on 7/30/2015.
 */
public class StateRecords extends StateConstants{
    
    public String addRecord(String name, String shortName, String headq, String language){
        return addName(name) + "," + addShortName(shortName) + "," + addHeadq(headq) + "," + addLanguage(language);
    }

    private String addName(String stateName){
        ArrayList<String> stateNames = new ArrayList<String>(Arrays.asList(NAMES));
        stateNames.add(stateName);
        NAMES = new String[stateNames.size()];
        NAMES = stateNames.toArray(NAMES);

        return NAMES[NAMES.length - 1];
    }

    private String addShortName(String shortName) {
        ArrayList<String> shortNames = new ArrayList<String>(Arrays.asList(SHORT_NAMES));
        shortNames.add(shortName);
        SHORT_NAMES = new String[shortNames.size()];
        SHORT_NAMES = shortNames.toArray(SHORT_NAMES);

        return SHORT_NAMES[SHORT_NAMES.length - 1];
    }

    private String addHeadq(String headq) {
        ArrayList<String> headqs = new ArrayList<String>(Arrays.asList(HEADQS));
        headqs.add(headq);
        HEADQS = new String[headqs.size()];
        HEADQS = headqs.toArray(HEADQS);

        return HEADQS[HEADQS.length - 1];
    }

    private String addLanguage(String language) {
        ArrayList<String> languages = new ArrayList<String>(Arrays.asList(LANGUAGES));
        languages.add(language);
        LANGUAGES = new String[languages.size()];
        LANGUAGES = languages.toArray(LANGUAGES);

        return LANGUAGES[LANGUAGES.length - 1];
    }

    public String getState(String shortName){
        int index = getShortName(shortName);
        if (index == -1)
            return NOT_FOUND;
        return (new State(NAMES[index], shortName, HEADQS[index], LANGUAGES[index])).toString();

    }

    private int getShortName(String shortName) {
        ArrayList<String> shortNames = new ArrayList<String>(Arrays.asList(SHORT_NAMES));

        if (shortNames.contains(shortName))
            return shortNames.indexOf(shortName);
        return -1;
    }
}
