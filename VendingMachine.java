class VendingMachine {
    private VendingMachineState currentState;
    
    // Business data
    private double balance = 0.0;
    private final java.util.Map<String, Integer> inventory = new java.util.HashMap<>();
    private String selectedItem = null;
    private double itemPrice = 0.0;

    public VendingMachine() {
        // Initial state
        this.currentState = new IdleState();
        // Sample inventory
        inventory.put("A1", 5);  // e.g. Cola - 5 left
        inventory.put("A2", 3);  // e.g. Chips
        inventory.put("B1", 0);  // out of stock example
    }

    // State transition helper
    public void changeState(VendingMachineState newState) {
        this.currentState = newState;
        System.out.println("→ Machine state changed to: " + newState.getClass().getSimpleName());
    }

    // Public API - delegates to current state
    public void selectItem(String itemCode) {
        currentState.selectItem(this, itemCode);
    }

    public void insertCoin(double amount) {
        currentState.insertCoin(this, amount);
    }

    public void dispenseItem() {
        currentState.dispenseItem(this);
    }

    public void setOutOfOrder() {
        currentState.setOutOfOrder(this);
    }

    // Getters/Setters for state classes to use
    public double getBalance() {
        return balance;
    }

    public void addToBalance(double amount) {
        this.balance += amount;
    }

    public String getSelectedItem() {
        return selectedItem;
    }

    public void setSelectedItem(String itemCode, double price) {
        this.selectedItem = itemCode;
        this.itemPrice = price;
    }

    public void clearSelection() {
        this.selectedItem = null;
        this.itemPrice = 0.0;
    }

    public boolean hasItem(String itemCode) {
        return inventory.getOrDefault(itemCode, 0) > 0;
    }

    public void decreaseInventory(String itemCode) {
        inventory.compute(itemCode, (k, v) -> (v == null || v <= 0) ? 0 : v - 1);
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void resetBalance() {
        this.balance = 0.0;
    }
}