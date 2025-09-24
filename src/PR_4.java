interface PhoneOwnerInterface {
    String getFullName();
    String getPhoneNumber();
    void printInfo();
}

class PhoneOwner implements PhoneOwnerInterface {
    String surname;
    String name;
    String patronymic;
    String address;
    String phoneNumber;

    PhoneOwner(String surname, String name, String patronymic, String address, String phoneNumber) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    // Реализация методов интерфейса
    public String getFullName() {
        return surname + " " + name + " " + patronymic;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void printInfo() {
        System.out.println("ФИО: " + getFullName());
        System.out.println("Адрес: " + address);
        System.out.println("Номер телефона: " + phoneNumber);
        System.out.println();
    }
}

class Main {
    public static void main(String[] args) {
        PhoneOwner[] owners = new PhoneOwner[] {
                new PhoneOwner("Иванов", "Иван", "Иванович", "Москва, ул. Ленина, 10, кв. 5", "+7 900 111 22 33"),
                new PhoneOwner("Петров", "Петр", "Петрович", "Екатеринбург, ул. Мира, 25, кв. 12", "+7 901 222 33 44"),
                new PhoneOwner("Сидоров", "Сидр", "Сидорович", "Москва, ул. Пушкина, 7, кв. 3", "+7 902 333 44 55"),
        };

        System.out.println("Все владельцы телефонов:");
        for (PhoneOwner owner : owners) {
            owner.printInfo();
        }

        System.out.println("Владельцы из Москвы:");
        for (PhoneOwner owner : owners) {
            if (owner.address.contains("Москва")) {
                owner.printInfo();
            }
        }

        System.out.println("Владельцы с номерами, начинающимися на +7 900:");
        for (PhoneOwner owner : owners) {
            if (owner.phoneNumber.startsWith("+7 900")) {
                owner.printInfo();
            }
        }
    }
}