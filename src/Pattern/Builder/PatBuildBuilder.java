package Pattern.Builder;

public class PatBuildBuilder {

    private String name;
    private String surname;
    private String country;
    private String city;
    private String address;

    public PatBuildBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PatBuildBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PatBuildBuilder setCountry(String country) {
        this.country = country;
        return this;
    }

    public PatBuildBuilder setCity(String city) {
        this.city = city;
        return this;
    }

    public PatBuildBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public PatBuild createPatBuild() {
        return new PatBuild(name, surname, country, city, address);
    }
}