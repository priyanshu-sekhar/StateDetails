package StateDetails.src;

/**
 * @author Priyanshu Sekhar Patra
 */
class State {
    private String name;
    private String shortName;
    private String headQ;
    private String language;

    public State(String name, String shortName, String headQ, String language) {
        this.shortName = shortName;
        this.name = name;
        this.headQ = headQ;
        this.language = language;
    }

    @Override
    public String toString() {
        return "<State><name>" + name + "</name><shortname>" + shortName + "</shortname>" +
                "<headq>" + headQ + "</headq><language>" + language + "</language></State>";
    }
}

