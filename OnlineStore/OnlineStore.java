import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class OnlineStore {
    Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to ZonKala !");
        Admin admin = new Admin();
        int x = 10, inputID;
        while (x != -1) {
            switch (x) {
                case 0:
                    x = mainMenu();
                    break;
                case 10:
                    x = admin.adminMainMenu();
                    break;
                case 11:
                    admin.newProducer();
                    x = 10;
                    break;
                case 12:
                    admin.newDelivery();
                    x = 10;
                    break;
                case 13:
                    x = admin.statAdmin();
                    break;
                case 14:
                    x = admin.adminDiscount();
                    break;
                case 19:
                    x = admin.adminLogin();
                    break;
                case 20:
                    x = Producer.producers[Producer.currentProducer].producerMainMenu();
                    break;
                case 21:
                    x = Producer.producers[Producer.currentProducer].addProduct();
                    break;
                case 22:
                    x = Producer.producers[Producer.currentProducer].statProducer();
                    break;
                case 23:
                    x = Producer.producers[Producer.currentProducer].discount();
                    break;
                case 24:
                    x = Producer.producers[Producer.currentProducer].removeProduct();
                    break;
                case 25:
                    x = Producer.producers[Producer.currentProducer].getMoney();
                    break;
                case 26:
                    x = Producer.producers[Producer.currentProducer].soldProducts();
                    break;
                case 29:
                    System.out.println("Enter producer ID :");
                    inputID = input.nextInt();
                    if (inputID <= Producer.producerID) {
                        x = Producer.producers[inputID].producerLogin(inputID);
                    }
                    break;
                case 30:
                    x = Deliver.delivers[Deliver.currentDeliver].deliverMainMenu();
                    break;
                case 31:
                    x = Deliver.delivers[Deliver.currentDeliver].orderList();
                    break;
                case 32:
                    x = Deliver.delivers[Deliver.currentDeliver].sendingList();
                    break;
                case 33:
                    x = Deliver.delivers[Deliver.currentDeliver].sentList();
                    break;
                case 34:
                    x = Deliver.delivers[Deliver.currentDeliver].changeVehicle();
                    break;
                case 39:
                    System.out.println("Enter deliver ID :");
                    inputID = input.nextInt();
                    if (inputID <= Deliver.deliverID) {
                        x = Deliver.delivers[inputID].deliverLogin(inputID);
                    }
                    break;
                case 49:
                    System.out.println("Enter costumer's username : ");
                    String cusUser = input.next();
                    x = Customer.customerLogin(cusUser);
                    break;
                case 50:
                    x = Customer.customers[Customer.currentCustomer].customerMainMenu();
                    break;
                case 51:
                    x = Customer.customers[Customer.currentCustomer].producersList();
                    break;
                case 52:
                    x = Customer.customers[Customer.currentCustomer].categoryProducts();
                    break;
                case 53:
                    x = Customer.customers[Customer.currentCustomer].purchased();
                    break;
                case 54:
                    x = Customer.customers[Customer.currentCustomer].sendingOrder();
                    break;
                case 55:
                    x = Customer.customers[Customer.currentCustomer].producerProducts();
                    break;
                case 56:
                    x = Customer.customers[Customer.currentCustomer].purchasedHistory();
                    break;
                case 59:
                    x = Customer.register();
                    break;
                case 61:
                    x = Product.newElectric();
                    break;
                case 62:
                    x = Product.newFood();
                    break;
                case 63:
                    x = Product.newClothes();
                    break;
            }
        }
    }

    //0
    static int mainMenu() {
        Scanner input = new Scanner(System.in);
        int ans;
        System.out.printf("Choose one : \n" +
                "1. log in as admin \n" +
                "2. log in as producer \n" +
                "3. log in as deliver \n" +
                "4. log in as customer \n" +
                "5. sign up as a customer \n" +
                "0. Exit \n");
        ans = input.nextInt();
        switch (ans) {
            case 0:
                return -1;
            case 1:
                return 19;
            case 2:
                return 29;
            case 3:
                return 39;
            case 4:
                return 49;
            case 5:
                return 59;
            default:
                System.out.println("INVALID NUMBER !");
                return 0;
        }
    }
}

class Person {
    String username;
    String password;
}

class Admin extends Person {
    Scanner input = new Scanner(System.in);
    static boolean isAdmin;

    Admin() {
        username = "admin";
        System.out.println("Enter password for admin :");
        password = input.nextLine();
    }

    //11
    void newProducer() {
        String user;
        String pass;
        user = "Producer #" + Producer.producerID;
        System.out.println("Enter password for producer #" + Producer.producerID);
        pass = input.next();
        Producer temp = new Producer(user, pass);
        Producer.producers[Producer.producerID] = temp;
        Producer.producerID++;
    }

    //12
    void newDelivery() {
        String user;
        String pass;
        int vehicle;
        user = "Deliver #" + Deliver.deliverID;
        System.out.println("Enter password for deliver #" + Deliver.deliverID);
        pass = input.next();
        System.out.printf("Choose deliver's vehicle :\n" +
                "1. motorcycle \n" +
                "2. car \n" +
                "3. blue nissan \n");
        vehicle = input.nextInt();
        Deliver temp = new Deliver(user, pass, vehicle);
        Deliver.delivers[Deliver.deliverID] = temp;
        Deliver.deliverID++;
    }

    //19
    int adminLogin() {
        System.out.println("Enter password : ");
        String enteredPass = input.next();
        if (enteredPass.equals(password)) {
            return 10;
        } else {
            System.out.println("WRONG PASSWORD !");
            return 19;
        }
    }

    //10
    int adminMainMenu() {
        Admin.isAdmin = true;
        int ans;
        System.out.printf("Hey admin Choose one : \n" +
                "1. Add a producer \n" +
                "2. Add a deliver \n" +
                "3. statistics \n" +
                "4. discount \n" +
                "0. log out \n");
        ans = input.nextInt();
        switch (ans) {
            case 0:
                Admin.isAdmin = false;
                return 0;
            case 1:
                return 11;
            case 2:
                return 12;
            case 3:
                return 13;
            case 4:
                return 14;
            default:
                System.out.println("INVALID NUMBER !");
                return 10;
        }
    }

    //13
    int statAdmin() {
        int ans;
        System.out.printf("Hey admin Choose one : \n" +
                "1. producer's money \n" +
                "2. customer's purchased products \n" +
                "3. producer's sold products \n" +
                "4. deliver's sent products \n" +
                "5. deliver's to be sent products \n" +
                "6. deliver's ordered products \n" +
                "0. back \n");
        ans = input.nextInt();
        switch (ans) {
            case 0:
                return 10;
            case 1:
                System.out.println("Enter producer's ID :");
                Producer.currentProducer = input.nextInt();
                return 25;
            case 2:
                System.out.println("Enter customer's name :");
                String inputName = input.next();
                for (int i = 0; i < Customer.customerID; i++) {
                    if (inputName.equals(Customer.customers[i].username)) {
                        Customer.currentCustomer = i;
                        break;
                    }
                }
                return 56;
            case 3:
                System.out.println("Enter producer's ID :");
                Producer.currentProducer = input.nextInt();
                return 26;
            case 4:
                System.out.println("Enter deliver's ID :");
                Deliver.currentDeliver = input.nextInt();
                return 33;
            case 5:
                System.out.println("Enter deliver's ID :");
                Deliver.currentDeliver = input.nextInt();
                return 32;
            case 6:
                Deliver.currentDeliver = 1;
                return 31;
            default:
                System.out.println("INVALID NUMBER !");
                return 13;
        }
    }

    //14
    int adminDiscount() {
        System.out.println("Enter producer's ID :");
        Producer.currentProducer = input.nextInt();
        return 23;
    }
}

class Producer extends Person {
    Scanner input = new Scanner(System.in);
    float money;
    static int producerID = 1;
    static int currentProducer;
    static Producer[] producers = new Producer[100];

    Producer(String user, String pass) {
        username = user;
        password = pass;
    }

    //20
    int producerMainMenu() {
        int ans;
        System.out.printf("Hey producer #%d Choose one : \n" +
                "1. Add a product \n" +
                "2. statistics \n" +
                "3. discount \n" +
                "4. remove a product \n" +
                "0. log out \n", currentProducer);
        ans = input.nextInt();
        switch (ans) {
            case 0:
                return 0;
            case 1:
                return 21;
            case 2:
                return 22;
            case 3:
                return 23;
            case 4:
                return 24;
            default:
                System.out.println("INVALID NUMBER !");
                return 20;
        }
    }

    //29
    int producerLogin(int inputID) {
        System.out.println("Enter password for producer #" + inputID);
        String enteredPass = input.next();
        if (enteredPass.equals(producers[inputID].password)) {
            currentProducer = inputID;
            return 20;
        } else {
            System.out.println("WRONG PASSWORD !");
            return 29;
        }
    }

    //21
    int addProduct() {
        int ans;
        System.out.printf("Hey producer #%d Choose a category : \n" +
                "1. electric \n" +
                "2. food \n" +
                "3. clothes \n", currentProducer);
        ans = input.nextInt();
        switch (ans) {
            case 1:
                return 61;
            case 2:
                return 62;
            case 3:
                return 63;
            default:
                System.out.println("INVALID NUMBER !");
                return 21;
        }
    }

    //23
    int discount() {
        Product[] pArray = Product.products.toArray(new Product[Product.products.size()]);
        System.out.println("Choose a product : ");
        for (int i = 0; i < pArray.length; i++) {
            if (pArray[i].ownerID == currentProducer) {
                System.out.println((i + 1) + ". " + pArray[i].name + " , price : " + pArray[i].price + " $");
            }
        }
        int a = input.nextInt();
        a--;
        System.out.println("Enter discount percent :");
        float percent = input.nextFloat();
        percent = (float) ((100 - percent) / 100.00);
        pArray[a].price *= percent;
        if (Admin.isAdmin)
            return 10;
        return 20;
    }

    //24
    int removeProduct() {
        Product[] pArray = Product.products.toArray(new Product[Product.products.size()]);
        System.out.println("Choose a product to remove : ");
        for (int i = 0; i < pArray.length; i++) {
            if (pArray[i].ownerID == currentProducer) {
                System.out.println((i + 1) + ". " + pArray[i].name + " , price : " + pArray[i].price + " $" + " , volume : "
                        + pArray[i].volume);
            }
        }
        int a = input.nextInt();
        a--;
        Product.products.remove(a);
        return 20;
    }

    //22
    int statProducer() {
        int ans;
        System.out.printf("Hey producer #%d Choose one : \n" +
                        "1. earned money \n" +
                        "2. sold products \n"
                , currentProducer);
        ans = input.nextInt();
        switch (ans) {
            case 1:
                return 25;
            case 2:
                return 26;
            default:
                System.out.println("INVALID NUMBER !");
                return 22;
        }
    }

    //25
    int getMoney() {
        System.out.println("Producer #" + Producer.currentProducer + " earned money is : "
                + producers[Producer.currentProducer].money);
        int a = input.nextInt();
        if (Admin.isAdmin)
            return 13;
        return 20;
    }

    //26
    int soldProducts() {
        Product[] pArray = Product.products.toArray(new Product[Product.products.size()]);
        System.out.println("Sold products : (Enter 0 to exit)");
        for (int i = 0; i < pArray.length; i++) {
            if (pArray[i].ownerID == Producer.currentProducer) {
                System.out.print((i + 1) + ". " + pArray[i].name + " , price : " + pArray[i].price + " $" + " , volume : "
                        + pArray[i].volume);
                if (pArray[i].majorCategory == 1) {
                    Electric electric = (Electric) pArray[i];
                    if (pArray[i].minorCategory == 1) {
                        System.out.println(" , category : mobile phone , manufacture date : " + electric.manDate + ", screen size : "
                                + electric.screenSize + " , sold number : " + pArray[i].buyers.size());
                    } else if (pArray[i].minorCategory == 2) {
                        System.out.println(" , category : TV , manufacture date : " + electric.manDate + ", screen size : "
                                + electric.screenSize + " , sold number : " + pArray[i].buyers.size());
                    } else {
                        System.out.println(" , category : console , manufacture date : " + electric.manDate +
                                " , sold number : " + pArray[i].buyers.size());
                    }
                } else if (pArray[i].majorCategory == 2) {
                    Food food = (Food) pArray[i];
                    if (pArray[i].minorCategory == 1) {
                        System.out.println(" , category : junk food , expire date : " + food.expDate +
                                " , sold number : " + pArray[i].buyers.size());
                    } else if (pArray[i].minorCategory == 2) {
                        System.out.println(" , category : diary , expire date : " + food.expDate + " , sold number : "
                                + pArray[i].buyers.size());
                    } else {
                        System.out.println(" , category : vegetable , expire date : " + food.expDate + " , made in "
                                + food.city + " , sold number : " + pArray[i].buyers.size());
                    }
                }
                if (pArray[i].majorCategory == 3) {
                    Clothes clothes = (Clothes) pArray[i];
                    if (clothes.minorCategory == 1) {
                        if (clothes.pType == 1) {
                            System.out.println(" , category : man clothes , type : shirt , size : " + clothes.size
                                    + " , sold number : " + pArray[i].buyers.size());
                        } else if (clothes.pType == 2) {
                            System.out.println(" , category : man clothes , type : pants , size : " + clothes.size
                                    + " , sold number : " + pArray[i].buyers.size());
                        } else {
                            System.out.println(" , category : man clothes , type : shoes , size : " + clothes.size
                                    + " , sold number : " + pArray[i].buyers.size());
                        }
                    } else if (clothes.minorCategory == 2) {
                        if (clothes.pType == 1) {
                            System.out.println(" , category : woman clothes , type : shirt , size : " + clothes.size
                                    + " , sold number : " + pArray[i].buyers.size());
                        } else if (clothes.pType == 2) {
                            System.out.println(" , category : woman clothes , type : pants , size : " + clothes.size
                                    + " , sold number : " + pArray[i].buyers.size());
                        } else {
                            System.out.println(" , category : woman clothes , type : shoes , size : " + clothes.size
                                    + " , sold number : " + pArray[i].buyers.size());
                        }
                    } else {
                        if (clothes.pType == 1) {
                            System.out.println(" , category : child clothes , type : shirt , size : " + clothes.size
                                    + " , sold number : " + pArray[i].buyers.size());
                        } else if (clothes.pType == 2) {
                            System.out.println(" , category : child clothes , type : pants , size : " + clothes.size
                                    + " , sold number : " + pArray[i].buyers.size());
                        } else {
                            System.out.println(" , category : child clothes , type : shoes , size : " + clothes.size
                                    + " , sold number : " + pArray[i].buyers.size());
                        }
                    }
                }
            }
        }
        int a = input.nextInt();
        if (Admin.isAdmin)
            return 13;
        return 20;
    }
}

class Deliver extends Person {
    int vehicle;
    float totalVolume = 0;
    static Deliver[] delivers = new Deliver[100];
    static int deliverID = 1;
    Scanner input = new Scanner(System.in);
    static int currentDeliver;

    Deliver(String user, String pass, int vehicle) {
        this.vehicle = vehicle;
        username = user;
        password = pass;
    }

    //30
    int deliverMainMenu() {
        int ans;
        System.out.printf("Hey Deliver #%d Choose one : \n" +
                "1. orders list \n" +
                "2. being sent products  \n" +
                "3. sent products \n" +
                "4. change vehicle \n" +
                "0. log out \n", currentDeliver);
        ans = input.nextInt();
        switch (ans) {
            case 0:
                return 0;
            case 1:
                return 31;
            case 2:
                return 32;
            case 3:
                return 33;
            case 4:
                return 34;
            default:
                System.out.println("INVALID NUMBER !");
                return 30;
        }
    }

    //39
    int deliverLogin(int inputID) {
        System.out.println("Enter password for deliver #" + inputID);
        String enteredPass = input.next();
        if (enteredPass.equals(delivers[inputID].password)) {
            currentDeliver = inputID;
            return 30;
        } else {
            System.out.println("WRONG PASSWORD !");
            return 39;
        }
    }

    //31
    int orderList() {
        Product[] pArray = Product.products.toArray(new Product[Product.products.size()]);
        System.out.println("Choose one to move it to being sent list : ");
        for (int i = 0; i < pArray.length; i++) {
            for (int j = 0; j < pArray[i].status.size(); j++) {
                if (pArray[i].status.get(j) == 1) {
                    System.out.println((i + 1) + "." + (j + 1) + ". " + pArray[i].name + " , volume : " + pArray[i].volume +
                            " , buyer : " + Customer.customers[pArray[i].buyers.get(j)].username);
                }
            }
        }
        int a = input.nextInt();
        if (a == 0) {
            if (Admin.isAdmin)
                return 13;
            return 30;
        }
        a -= 11;
        if (pArray[a / 10].volume > 0.5 && this.vehicle == 1) {
            System.out.println("TOO HEAVY !");
            return 30;
        }
        if (pArray[a / 10].volume > 2 && this.vehicle == 2) {
            System.out.println("TOO HEAVY !");
            return 30;
        }
        if (pArray[a / 10].volume > 12 && this.vehicle == 3) {
            System.out.println("TOO HEAVY !");
            return 30;
        }
        pArray[a / 10].deliver = currentDeliver;
        pArray[a / 10].status.set(a % 10, 2);
        return 30;
    }

    //32
    int sendingList() {
        Product[] pArray = Product.products.toArray(new Product[Product.products.size()]);
        System.out.println("Choose one to move it to sent products list : ");
        for (int i = 0; i < pArray.length; i++) {
            for (int j = 0; j < pArray[i].status.size(); j++) {
                if (pArray[i].status.get(j) == 2 && pArray[i].deliver == currentDeliver) {
                    System.out.println((i + 1) + "." + (j + 1) + ". " + pArray[i].name + " , volume : " + pArray[i].volume +
                            " , buyer : " + Customer.customers[pArray[i].buyers.get(j)].username);
                }
            }
        }
        int a = input.nextInt();
        if (a == 0) {
            if (Admin.isAdmin)
                return 13;
            return 30;
        }
        a -= 11;
        pArray[a / 10].status.set(a % 10, 3);
        totalVolume += pArray[a / 10].volume;
        return 30;
    }

    //33
    int sentList() {
        Product[] pArray = Product.products.toArray(new Product[Product.products.size()]);
        System.out.println("sent products list : (enter 0 to back to main menu)");
        for (int i = 0; i < pArray.length; i++) {
            for (int j = 0; j < pArray[i].status.size(); j++) {
                if (pArray[i].status.get(j) == 3 && pArray[i].deliver == currentDeliver) {
                    System.out.println((i + 1) + "." + (j + 1) + ". " + pArray[i].name + " , volume : " + pArray[i].volume + " , buyer : "
                            + Customer.customers[pArray[i].buyers.get(j)].username);
                }
            }
        }
        System.out.println("total moved volume is :" + totalVolume);
        int a = input.nextInt();
        if (Admin.isAdmin)
            return 13;
        return 30;
    }

    //34
    int changeVehicle() {
        System.out.printf("Choose deliver's vehicle :\n" +
                "1. motorcycle \n" +
                "2. car \n" +
                "3. blue nissan \n");
        int a = input.nextInt();
        this.vehicle = a;
        return 30;
    }
}

class Customer extends Person {
    Scanner input = new Scanner(System.in);
    static Customer[] customers = new Customer[100];
    static int customerID = 0;
    static int currentCustomer;
    float spentMoney;

    Customer(String user, String pass) {
        username = user;
        password = pass;
    }

    //49
    static int customerLogin(String user) {
        Scanner input = new Scanner(System.in);
        currentCustomer = 0;
        while (!customers[currentCustomer].username.equals(user)) {
            currentCustomer++;
            if (currentCustomer == customerID) {
                System.out.println("INVALID USERNAME !");
                return 49;
            }
        }
        System.out.println("Enter password for " + customers[currentCustomer].username + " :");
        String pass = input.next();
        if (pass.equals(customers[currentCustomer].password)) {
            return 50;
        }
        System.out.println("INVALID PASSWORD !");
        return 49;
    }

    //50
    int customerMainMenu() {
        int ans;
        System.out.printf("Hey %s Choose one : \n" +
                "1. producers list \n" +
                "2. product category  \n" +
                "3. purchased products \n" +
                "4. in the send order products\n" +
                "0. log out \n", username);
        ans = input.nextInt();
        switch (ans) {
            case 0:
                return 0;
            case 1:
                return 51;
            case 2:
                return 52;
            case 3:
                return 53;
            case 4:
                return 54;
            default:
                System.out.println("INVALID NUMBER !");
                return 50;
        }
    }

    //59
    static int register() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter username for customer :");
        String user = input.next();
        for (int i = 0; i < customerID; i++) {
            if (user.equals(customers[i].username)) {
                System.out.println("Username is already taken !");
                return 59;
            }
        }
        System.out.println("Enter password for " + user + " :");
        String pass = input.next();
        Customer temp = new Customer(user, pass);
        customers[customerID] = temp;
        customerID++;
        return 49;
    }

    //51
    int producersList() {
        System.out.println("Choose a producer :");
        for (int i = 1; i < Producer.producerID; i++) {
            System.out.println("producer #" + i);
        }
        Producer.currentProducer = input.nextInt();
        return 55;
    }

    //55
    int producerProducts() {
        Product[] pArray = Product.products.toArray(new Product[Product.products.size()]);
        System.out.println("Which one do you want to buy ?");
        for (int i = 0; i < pArray.length; i++) {
            if (pArray[i].ownerID == Producer.currentProducer) {
                System.out.print((i + 1) + ". " + pArray[i].name + " , price : " + pArray[i].price + " $" + " , volume : "
                        + pArray[i].volume);
                if (pArray[i].majorCategory == 1) {
                    Electric electric = (Electric) pArray[i];
                    if (pArray[i].minorCategory == 1) {
                        System.out.println(" , category : mobile phone , manufacture date : " + electric.manDate + ", screen size : "
                                + electric.screenSize);
                    } else if (pArray[i].minorCategory == 2) {
                        System.out.println(" , category : TV , manufacture date : " + electric.manDate + ", screen size : "
                                + electric.screenSize);
                    } else {
                        System.out.println(" , category : console , manufacture date : " + electric.manDate);
                    }
                } else if (pArray[i].majorCategory == 2) {
                    Food food = (Food) pArray[i];
                    if (pArray[i].minorCategory == 1) {
                        System.out.println(" , category : junk food , expire date : " + food.expDate);
                    } else if (pArray[i].minorCategory == 2) {
                        System.out.println(" , category : diary , expire date : " + food.expDate);
                    } else {
                        System.out.println(" , category : vegetable , expire date : " + food.expDate + " , made in "
                                + food.city);
                    }
                }
                if (pArray[i].majorCategory == 3) {
                    Clothes clothes = (Clothes) pArray[i];
                    if (clothes.minorCategory == 1) {
                        if (clothes.pType == 1) {
                            System.out.println(" , category : man clothes , type : shirt , size : " + clothes.size);
                        } else if (clothes.pType == 2) {
                            System.out.println(" , category : man clothes , type : pants , size : " + clothes.size);
                        } else {
                            System.out.println(" , category : man clothes , type : shoes , size : " + clothes.size);
                        }
                    } else if (clothes.minorCategory == 2) {
                        if (clothes.pType == 1) {
                            System.out.println(" , category : woman clothes , type : shirt , size : " + clothes.size);
                        } else if (clothes.pType == 2) {
                            System.out.println(" , category : woman clothes , type : pants , size : " + clothes.size);
                        } else {
                            System.out.println(" , category : woman clothes , type : shoes , size : " + clothes.size);
                        }
                    } else {
                        if (clothes.pType == 1) {
                            System.out.println(" , category : child clothes , type : shirt , size : " + clothes.size);
                        } else if (clothes.pType == 2) {
                            System.out.println(" , category : child clothes , type : pants , size : " + clothes.size);
                        } else {
                            System.out.println(" , category : child clothes , type : shoes , size : " + clothes.size);
                        }
                    }
                }
            }
        }
        int a = input.nextInt();
        if (a == 0)
            return 50;
        pArray[a - 1].buyers.add(currentCustomer);
        pArray[a - 1].status.add(1);
        Producer.producers[Producer.currentProducer].money += pArray[a - 1].price;
        customers[currentCustomer].spentMoney += pArray[a - 1].price;
        return 50;
    }

    //52
    int categoryProducts() {
        Product[] pArray = Product.products.toArray(new Product[Product.products.size()]);
        int major, minor;
        System.out.printf("Choose a category : \n" +
                "1. electric \n" +
                "2. food \n" +
                "3. clothes \n");
        major = input.nextInt();
        switch (major) {
            case 1:
                System.out.printf("Choose a category : \n" +
                        "1. mobile phone \n" +
                        "2. TV \n" +
                        "3. console \n");
                break;
            case 2:
                System.out.printf("Choose a category : \n" +
                        "1. junk food \n" +
                        "2. dairy \n" +
                        "3. vegetable \n");
                break;
            case 3:
                System.out.printf("Choose a category : \n" +
                        "1. man clothes\n" +
                        "2. woman clothes\n" +
                        "3. child clothes\n");
                break;
        }
        minor = input.nextInt();
        for (int i = 0; i < pArray.length; i++) {
            if (pArray[i].majorCategory == major && major == 1) {
                Electric electric = (Electric) pArray[i];
                if (pArray[i].minorCategory == minor && minor == 1) {
                    System.out.print((i + 1) + ". " + pArray[i].name + " , price : " + pArray[i].price + " $" + " , volume : "
                            + pArray[i].volume + " , producer ID : " + pArray[i].ownerID);
                    System.out.println(" , category : mobile phone , manufacture date : " + electric.manDate + ", screen size : "
                            + electric.screenSize);
                } else if (pArray[i].minorCategory == minor && minor == 2) {
                    System.out.print((i + 1) + ". " + pArray[i].name + " , price : " + pArray[i].price + " $" + " , volume : "
                            + pArray[i].volume + " , producer ID : " + pArray[i].ownerID);
                    System.out.println(" , category : TV , manufacture date : " + electric.manDate + ", screen size : "
                            + electric.screenSize);
                } else if (pArray[i].minorCategory == minor && minor == 3) {
                    System.out.print((i + 1) + ". " + pArray[i].name + " , price : " + pArray[i].price + " $" + " , volume : "
                            + pArray[i].volume + " , producer ID : " + pArray[i].ownerID);
                    System.out.println(" , category : console , manufacture date : " + electric.manDate);
                }
            } else if (pArray[i].majorCategory == major && major == 2) {
                Food food = (Food) pArray[i];
                if (pArray[i].minorCategory == minor && minor == 1) {
                    System.out.print((i + 1) + ". " + pArray[i].name + " , price : " + pArray[i].price + " $" + " , volume : "
                            + pArray[i].volume + " , producer ID : " + pArray[i].ownerID);
                    System.out.println(" , category : junk food , expire date : " + food.expDate);
                } else if (pArray[i].minorCategory == minor && minor == 2) {
                    System.out.print((i + 1) + ". " + pArray[i].name + " , price : " + pArray[i].price + " $" + " , volume : "
                            + pArray[i].volume + " , producer ID : " + pArray[i].ownerID);
                    System.out.println(" , category : diary , expire date : " + food.expDate);
                } else if (pArray[i].minorCategory == minor && minor == 3) {
                    System.out.print((i + 1) + ". " + pArray[i].name + " , price : " + pArray[i].price + " $" + " , volume : "
                            + pArray[i].volume + " , producer ID : " + pArray[i].ownerID);
                    System.out.println(" , category : vegetable , expire date : " + food.expDate + " , made in " + food.city);
                }
            }
            if (pArray[i].majorCategory == major && major == 3) {
                System.out.printf("Choose a category : \n" +
                        "1. shirt\n" +
                        "2. pants\n" +
                        "3. shoes\n");
                int type = input.nextInt();
                Clothes clothes = (Clothes) pArray[i];
                if (clothes.minorCategory == minor && minor == 1) {
                    if (clothes.pType == type && type == 1) {
                        System.out.print((i + 1) + ". " + pArray[i].name + " , price : " + pArray[i].price + " $" +
                                " , volume : " + pArray[i].volume + " , producer ID : " + pArray[i].ownerID);
                        System.out.println(" , category : man clothes , type : shirt , size : " + clothes.size);
                    } else if (clothes.pType == type && type == 2) {
                        System.out.print((i + 1) + ". " + pArray[i].name + " , price : " + pArray[i].price + " $" +
                                " , volume : " + pArray[i].volume + " , producer ID : " + pArray[i].ownerID);
                        System.out.println(" , category : man clothes , type : pants , size : " + clothes.size);
                    } else if (clothes.pType == type && type == 3) {
                        System.out.print((i + 1) + ". " + pArray[i].name + " , price : " + pArray[i].price + " $" +
                                " , volume : " + pArray[i].volume + " , producer ID : " + pArray[i].ownerID);
                        System.out.println(" , category : man clothes , type : shoes , size : " + clothes.size);
                    }
                } else if (clothes.minorCategory == minor && minor == 2) {
                    if (clothes.pType == type && type == 1) {
                        System.out.print((i + 1) + ". " + pArray[i].name + " , price : " + pArray[i].price + " $" +
                                " , volume : " + pArray[i].volume + " , producer ID : " + pArray[i].ownerID);
                        System.out.println(" , category : woman clothes , type : shirt , size : " + clothes.size);
                    } else if (clothes.pType == type && type == 2) {
                        System.out.print((i + 1) + ". " + pArray[i].name + " , price : " + pArray[i].price + " $" +
                                " , volume : " + pArray[i].volume + " , producer ID : " + pArray[i].ownerID);
                        System.out.println(" , category : woman clothes , type : pants , size : " + clothes.size);
                    } else if (clothes.pType == type && type == 3) {
                        System.out.print((i + 1) + ". " + pArray[i].name + " , price : " + pArray[i].price + "$" +
                                " , volume : " + pArray[i].volume + " , producer ID : " + pArray[i].ownerID);
                        System.out.println(" , category : woman clothes , type : shoes , size : " + clothes.size);
                    }
                } else if (clothes.minorCategory == minor && minor == 3) {
                    if (clothes.pType == type && type == 1) {
                        System.out.print((i + 1) + ". " + pArray[i].name + " , price : " + pArray[i].price + "$" +
                                " , volume : " + pArray[i].volume + " , producer ID : " + pArray[i].ownerID);
                        System.out.println(" , category : child clothes , type : shirt , size : " + clothes.size);
                    } else if (clothes.pType == 2) {
                        System.out.print((i + 1) + ". " + pArray[i].name + " , price : " + pArray[i].price + "$" +
                                " , volume : " + pArray[i].volume + " , producer ID : " + pArray[i].ownerID);
                        System.out.println(" , category : child clothes , type : pants , size : " + clothes.size);
                    } else if (clothes.pType == type && type == 3) {
                        System.out.print((i + 1) + ". " + pArray[i].name + " , price : " + pArray[i].price + "$" +
                                " , volume : " + pArray[i].volume + " , producer ID : " + pArray[i].ownerID);
                        System.out.println(" , category : child clothes , type : shoes , size : " + clothes.size);
                    }
                }
            }
        }
        int a = input.nextInt();
        if (a == 0)
            return 50;
        pArray[a - 1].buyers.add(currentCustomer);
        pArray[a - 1].status.add(1);
        Producer.producers[Producer.currentProducer].money += pArray[a - 1].price;
        customers[currentCustomer].spentMoney += pArray[a - 1].price;
        return 50;
    }

    //53
    int purchased() {
        Product[] pArray = Product.products.toArray(new Product[Product.products.size()]);
        System.out.println("purchased list : (enter 0 to back to main menu)");
        for (int i = 0; i < pArray.length; i++) {
            for (int j = 0; j < pArray[i].status.size(); j++) {
                if (pArray[i].status.get(j) == 3 && pArray[i].buyers.get(j) == currentCustomer) {
                    System.out.print((i + 1) + ". " + pArray[i].name + " , price : " + pArray[i].price + " $" + " , volume : "
                            + pArray[i].volume);
                    if (pArray[i].majorCategory == 1) {
                        Electric electric = (Electric) pArray[i];
                        if (pArray[i].minorCategory == 1) {
                            System.out.println(" , category : mobile phone , manufacture date : " + electric.manDate + ", screen size : "
                                    + electric.screenSize);
                        } else if (pArray[i].minorCategory == 2) {
                            System.out.println(" , category : TV , manufacture date : " + electric.manDate + ", screen size : "
                                    + electric.screenSize);
                        } else {
                            System.out.println(" , category : console , manufacture date : " + electric.manDate);
                        }
                    } else if (pArray[i].majorCategory == 2) {
                        Food food = (Food) pArray[i];
                        if (pArray[i].minorCategory == 1) {
                            System.out.println(" , category : junk food , expire date : " + food.expDate);
                        } else if (pArray[i].minorCategory == 2) {
                            System.out.println(" , category : diary , expire date : " + food.expDate);
                        } else {
                            System.out.println(" , category : vegetable , expire date : " + food.expDate + " , made in "
                                    + food.city);
                        }
                    }
                    if (pArray[i].majorCategory == 3) {
                        Clothes clothes = (Clothes) pArray[i];
                        if (clothes.minorCategory == 1) {
                            if (clothes.pType == 1) {
                                System.out.println(" , category : man clothes , type : shirt , size : " + clothes.size);
                            } else if (clothes.pType == 2) {
                                System.out.println(" , category : man clothes , type : pants , size : " + clothes.size);
                            } else {
                                System.out.println(" , category : man clothes , type : shoes , size : " + clothes.size);
                            }
                        } else if (clothes.minorCategory == 2) {
                            if (clothes.pType == 1) {
                                System.out.println(" , category : woman clothes , type : shirt , size : " + clothes.size);
                            } else if (clothes.pType == 2) {
                                System.out.println(" , category : woman clothes , type : pants , size : " + clothes.size);
                            } else {
                                System.out.println(" , category : woman clothes , type : shoes , size : " + clothes.size);
                            }
                        } else {
                            if (clothes.pType == 1) {
                                System.out.println(" , category : child clothes , type : shirt , size : " + clothes.size);
                            } else if (clothes.pType == 2) {
                                System.out.println(" , category : child clothes , type : pants , size : " + clothes.size);
                            } else {
                                System.out.println(" , category : child clothes , type : shoes , size : " + clothes.size);
                            }
                        }
                    }
                }
            }
        }
        System.out.println("spent money :" + customers[currentCustomer].spentMoney);
        int a = input.nextInt();
        return 50;
    }

    //54
    int sendingOrder() {
        Product[] pArray = Product.products.toArray(new Product[Product.products.size()]);
        System.out.println("sending order list : (enter 0 to back to main menu)");
        for (int i = 0; i < pArray.length; i++) {
            for (int j = 0; j < pArray[i].status.size(); j++) {
                if (pArray[i].status.get(j) != 3 && pArray[i].buyers.get(j) == currentCustomer) {
                    System.out.print((i + 1) + ". " + pArray[i].name + " , price : " + pArray[i].price + " $" + " , volume : "
                            + pArray[i].volume);
                    if (pArray[i].majorCategory == 1) {
                        Electric electric = (Electric) pArray[i];
                        if (pArray[i].minorCategory == 1) {
                            System.out.println(" , category : mobile phone , manufacture date : " + electric.manDate + ", screen size : "
                                    + electric.screenSize);
                        } else if (pArray[i].minorCategory == 2) {
                            System.out.println(" , category : TV , manufacture date : " + electric.manDate + ", screen size : "
                                    + electric.screenSize);
                        } else {
                            System.out.println(" , category : console , manufacture date : " + electric.manDate);
                        }
                    } else if (pArray[i].majorCategory == 2) {
                        Food food = (Food) pArray[i];
                        if (pArray[i].minorCategory == 1) {
                            System.out.println(" , category : junk food , expire date : " + food.expDate);
                        } else if (pArray[i].minorCategory == 2) {
                            System.out.println(" , category : diary , expire date : " + food.expDate);
                        } else {
                            System.out.println(" , category : vegetable , expire date : " + food.expDate + " , made in "
                                    + food.city);
                        }
                    }
                    if (pArray[i].majorCategory == 3) {
                        Clothes clothes = (Clothes) pArray[i];
                        if (clothes.minorCategory == 1) {
                            if (clothes.pType == 1) {
                                System.out.println(" , category : man clothes , type : shirt , size : " + clothes.size);
                            } else if (clothes.pType == 2) {
                                System.out.println(" , category : man clothes , type : pants , size : " + clothes.size);
                            } else {
                                System.out.println(" , category : man clothes , type : shoes , size : " + clothes.size);
                            }
                        } else if (clothes.minorCategory == 2) {
                            if (clothes.pType == 1) {
                                System.out.println(" , category : woman clothes , type : shirt , size : " + clothes.size);
                            } else if (clothes.pType == 2) {
                                System.out.println(" , category : woman clothes , type : pants , size : " + clothes.size);
                            } else {
                                System.out.println(" , category : woman clothes , type : shoes , size : " + clothes.size);
                            }
                        } else {
                            if (clothes.pType == 1) {
                                System.out.println(" , category : child clothes , type : shirt , size : " + clothes.size);
                            } else if (clothes.pType == 2) {
                                System.out.println(" , category : child clothes , type : pants , size : " + clothes.size);
                            } else {
                                System.out.println(" , category : child clothes , type : shoes , size : " + clothes.size);
                            }
                        }
                    }
                }
            }
        }
        int a = input.nextInt();
        if (a != 0)
            return 54;
        return 50;
    }

    //56
    int purchasedHistory() {
        Product[] pArray = Product.products.toArray(new Product[Product.products.size()]);
        System.out.println("purchased list : (enter 0 to back to main menu)");
        for (int i = 0; i < pArray.length; i++) {
            for (int j = 0; j < pArray[i].status.size(); j++) {
                if (pArray[i].buyers.get(j) == currentCustomer) {
                    System.out.print((i + 1) + ". " + pArray[i].name + " , price : " + pArray[i].price + " $" + " , volume : "
                            + pArray[i].volume);
                    if (pArray[i].majorCategory == 1) {
                        Electric electric = (Electric) pArray[i];
                        if (pArray[i].minorCategory == 1) {
                            System.out.println(" , category : mobile phone , manufacture date : " + electric.manDate + ", screen size : "
                                    + electric.screenSize);
                        } else if (pArray[i].minorCategory == 2) {
                            System.out.println(" , category : TV , manufacture date : " + electric.manDate + ", screen size : "
                                    + electric.screenSize);
                        } else {
                            System.out.println(" , category : console , manufacture date : " + electric.manDate);
                        }
                    } else if (pArray[i].majorCategory == 2) {
                        Food food = (Food) pArray[i];
                        if (pArray[i].minorCategory == 1) {
                            System.out.println(" , category : junk food , expire date : " + food.expDate);
                        } else if (pArray[i].minorCategory == 2) {
                            System.out.println(" , category : diary , expire date : " + food.expDate);
                        } else {
                            System.out.println(" , category : vegetable , expire date : " + food.expDate + " , made in "
                                    + food.city);
                        }
                    }
                    if (pArray[i].majorCategory == 3) {
                        Clothes clothes = (Clothes) pArray[i];
                        if (clothes.minorCategory == 1) {
                            if (clothes.pType == 1) {
                                System.out.println(" , category : man clothes , type : shirt , size : " + clothes.size);
                            } else if (clothes.pType == 2) {
                                System.out.println(" , category : man clothes , type : pants , size : " + clothes.size);
                            } else {
                                System.out.println(" , category : man clothes , type : shoes , size : " + clothes.size);
                            }
                        } else if (clothes.minorCategory == 2) {
                            if (clothes.pType == 1) {
                                System.out.println(" , category : woman clothes , type : shirt , size : " + clothes.size);
                            } else if (clothes.pType == 2) {
                                System.out.println(" , category : woman clothes , type : pants , size : " + clothes.size);
                            } else {
                                System.out.println(" , category : woman clothes , type : shoes , size : " + clothes.size);
                            }
                        } else {
                            if (clothes.pType == 1) {
                                System.out.println(" , category : child clothes , type : shirt , size : " + clothes.size);
                            } else if (clothes.pType == 2) {
                                System.out.println(" , category : child clothes , type : pants , size : " + clothes.size);
                            } else {
                                System.out.println(" , category : child clothes , type : shoes , size : " + clothes.size);
                            }
                        }
                    }
                }
            }
        }
        System.out.println("spent money :" + customers[currentCustomer].spentMoney);
        int a = input.nextInt();
        return 13;
    }
}

class Product {
    Scanner input = new Scanner(System.in);
    String name;
    int ownerID;
    float volume, price;
    int majorCategory, minorCategory;
    static List<Product> products = new LinkedList<>();
    LinkedList<Integer> buyers = new LinkedList();
    LinkedList<Integer> status = new LinkedList();
    int deliver = -1;

    //61
    static int newElectric() {
        Product temp = new Electric();
        products.add(temp);
        return 20;
    }

    //62
    static int newFood() {
        Product temp = new Food();
        products.add(temp);
        return 20;
    }

    //63
    static int newClothes() {
        Product temp = new Clothes();
        products.add(temp);
        return 20;
    }
}

class Electric extends Product {
    String manDate;
    int screenSize = -1;

    Electric() {
        ownerID = Producer.currentProducer;
        majorCategory = 1;
        System.out.printf("Choose a category : \n" +
                "1. mobile phone \n" +
                "2. TV \n" +
                "3. console \n");
        minorCategory = input.nextInt();
        System.out.println("Enter the name of the product :");
        name = input.next();
        System.out.println("Enter the volume of the product :");
        volume = input.nextFloat();
        System.out.println("Enter the price of the product :");
        price = input.nextFloat();
        System.out.println("Enter the manufacture date of the product :");
        manDate = input.next();
        if (minorCategory != 3) {
            System.out.println("Enter the screen size of the product :");
            screenSize = input.nextInt();
        }
    }
}

class Food extends Product {
    String expDate;
    String city;

    Food() {
        ownerID = Producer.currentProducer;
        majorCategory = 2;
        System.out.printf("Choose a category : \n" +
                "1. junk food \n" +
                "2. dairy \n" +
                "3. vegetable \n");
        minorCategory = input.nextInt();
        System.out.println("Enter the name of the product :");
        name = input.next();
        System.out.println("Enter the volume of the product :");
        volume = input.nextFloat();
        System.out.println("Enter the price of the product :");
        price = input.nextFloat();
        System.out.println("Enter the expire date of the product :");
        expDate = input.next();
        if (minorCategory == 3) {
            System.out.println("Enter the manufacture city of the product :");
            city = input.next();
        }
    }
}

class Clothes extends Product {
    String size;
    int pType;

    Clothes() {
        ownerID = Producer.currentProducer;
        majorCategory = 3;
        System.out.printf("Choose a category : \n" +
                "1. man clothes\n" +
                "2. woman clothes\n" +
                "3. child clothes\n");
        minorCategory = input.nextInt();
        System.out.printf("Choose a category : \n" +
                "1. shirt\n" +
                "2. pants\n" +
                "3. shoes\n");
        pType = input.nextInt();
        System.out.println("Enter the name of the product :");
        name = input.next();
        System.out.println("Enter the volume of the product :");
        volume = input.nextFloat();
        System.out.println("Enter the price of the product :");
        price = input.nextFloat();
        System.out.println("Enter the size of the product :");
        size = input.next();
    }
}


