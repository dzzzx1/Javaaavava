class Main {

    static class Person {
        private String lastName;
        private String firstName;
        private String middleName;
        private String gender;
        private int age;

        public Person(String lastName, String firstName, String middleName, String gender, int age) {
            this.lastName = lastName;
            this.firstName = firstName;
            this.middleName = middleName;
            this.gender = gender;
            this.age = age;
        }


        public String getLastName() { return lastName; }
        public String getFirstName() { return firstName; }
        public String getMiddleName() { return middleName; }
        public String getGender() { return gender; }
        public int getAge() { return age; }

        public void printInfo() {
            System.out.println(lastName + " " + firstName + " " + middleName +
                    ", Пол: " + gender +
                    ", Возраст: " + age);
        }
    }


    static class Address {
        private String postalCode;
        private String country;
        private String region;
        private String district;
        private String city;
        private String street;
        private String house;
        private String apartment;

        public Address(String postalCode, String country, String region, String district,
                       String city, String street, String house, String apartment) {
            this.postalCode = postalCode;
            this.country = country;
            this.region = region;
            this.district = district;
            this.city = city;
            this.street = street;
            this.house = house;
            this.apartment = apartment;
        }

        @Override
        public String toString() {
            return postalCode + ", " + country + ", " + region + ", " + district +
                    ", " + city + ", " + street + ", " + house + ", " + apartment;
        }
    }


    static class PhoneOwner extends Person {
        private Address address;
        private String phoneNumber;

        public PhoneOwner(String lastName, String firstName, String middleName,
                          String gender, int age, Address address, String phoneNumber) {
            super(lastName, firstName, middleName, gender, age);
            this.address = address;
            this.phoneNumber = phoneNumber;
        }

        @Override
        public void printInfo() {
            super.printInfo();
            System.out.println("Адрес: " + address.toString() +
                    ", Телефон: " + phoneNumber);
        }
    }

    // Тест
    public static void main(String[] args) {
        Address address1 = new Address("123456", "Россия", "Ростовская область", "Ленинский район",
                "Ростов-на-Дону", "ул. Ленина", "10", "5");
        PhoneOwner owner1 = new PhoneOwner("Иванов", "Иван", "Иванович", "М", 45, address1, "+7-111-222-33-44");

        owner1.printInfo();
    }
}