import java.util.*;

class DumplingShop {
    private Map<String, Integer> dumplings;

    public DumplingShop(int initialQuantity) {
        dumplings = new HashMap<>();
        dumplings.put("pork", initialQuantity);
        dumplings.put("beef", initialQuantity);
        dumplings.put("vegetable", initialQuantity);
    }

    public synchronized void orderDumplings(Map<String, Integer> order) {
        for (Map.Entry<String, Integer> entry : order.entrySet()) {
            String type = entry.getKey();
            int quantity = entry.getValue();

            if (dumplings.containsKey(type) && dumplings.get(type) >= quantity) {
                dumplings.put(type, dumplings.get(type) - quantity);
                System.out.println(quantity + " " + type + " dumplings sold.");
            } else {
                System.out.println("Not enough " + type + " dumplings.");
            }
        }
    }

    public synchronized boolean hasDumplings() {
        for (int quantity : dumplings.values()) {
            if (quantity > 0) {
                return true;
            }
        }
        return false;
    }

    public synchronized boolean isSoldOut(String type) {
        return dumplings.containsKey(type) && dumplings.get(type) <= 0;
    }
}

class Customer implements Runnable {
    private static final int MIN_QUANTITY = 10;
    private static final int MAX_QUANTITY = 50;

    private static final String[] DUMPLING_TYPES = {"pork", "beef", "vegetable"};

    private static final Object lock = new Object();

    private static int nextCustomerNum = 1;

    private DumplingShop dumplingShop;
    private int customerNum;

    public Customer(DumplingShop dumplingShop) {
        this.dumplingShop = dumplingShop;
        synchronized (lock) {
            this.customerNum = nextCustomerNum++;
        }
    }

    @Override
    public void run() {
        Random random = new Random();
        Map<String, Integer> order = new HashMap<>();

        int numTypes = random.nextInt(DUMPLING_TYPES.length) + 1;
        List<String> selectedTypes = new ArrayList<>(Arrays.asList(DUMPLING_TYPES));

        for (int i = 0; i < numTypes; i++) {
            int index = random.nextInt(selectedTypes.size());
            String type = selectedTypes.get(index);
            selectedTypes.remove(index);

            int quantity = random.nextInt(MAX_QUANTITY - MIN_QUANTITY + 1) + MIN_QUANTITY;
            order.put(type, quantity);
        }

        System.out.println("Customer " + customerNum + " wants to order: " + order);
        dumplingShop.orderDumplings(order);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class A1093370_0512_1 {
    private static final String[] DUMPLING_TYPES = {"pork", "beef", "vegetable"};
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("請輸入同時光顧的顧客數目：");
        int numCustomers = scanner.nextInt();

        DumplingShop dumplingShop = new DumplingShop(5000);

        Thread[] customerThreads = new Thread[numCustomers];
        for (int i = 0; i < numCustomers; i++) {
            Customer customer = new Customer(dumplingShop);
            customerThreads[i] = new Thread(customer);
        }

        for (Thread customerThread : customerThreads) {
            customerThread.start();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (Thread customerThread : customerThreads) {
            try {
                customerThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // 檢查各類水饺是否售完
        for (String type : DUMPLING_TYPES) {
            if (dumplingShop.isSoldOut(type)) {
                System.out.println(type + " dumplings are sold out.");
            }
        }

        scanner.close();
    }
}
