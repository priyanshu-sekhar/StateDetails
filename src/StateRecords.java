package StateDetails.src;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Database class to which a State can be added or retrieved from
 */
public class StateRecords extends StateConstants{

    @GET
    @Path("/{param}")
    @Produces("application/json")
    public String getMsg(@PathParam("param") String shortName) {
        int index = getShortName(shortName);
        if (index == -1)
            return NOT_FOUND;
        return (new State(NAMES[index], shortName, HEADQS[index], LANGUAGES[index])).toString();
    }

    /**
     * This adds a new State to the existing database
     * @param name Name of the State
     * @param shortName Short-notation/Abbreviation of the State
     * @param headq Headquarters of the State
     * @param language Official language of the State
     */
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

    /**
     * This is called to retrieve a State's details from the database using it's Short-Notation
     * @param shortName The Short-Notation of the desired State
     * @return details if the State exists in the records, else "Data Not Found"
     */
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
