package Pattern.Builder;

public class PatBuild {

    private String name;

    private String surname;

    private String country;

    private String city;

    private String address;

    PatBuild(String name, String surname, String country, String city, String address) {
        this.name = name;
        this.surname = surname;
        this.country = country;
        this.city = city;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getAddress() {
        return address;
    }

    public static void main(String[] args) {

        PatBuild patBuild = new PatBuildBuilder().setAddress("desert")
                .setCity("Kimchybator")
                .setCountry("Mongolia")
                .setName("Timuchin")
                .setSurname("Mamaev")
                .createPatBuild();
    }
}
