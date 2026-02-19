class IdleState implements VendingMachineState {
    @Override
    public void selectItem(VendingMachine machine, String itemCode) {
        if (!machine.hasItem(itemCode)) {
            System.out.println("Sorry, item " + itemCode + " is out of stock.");
            return;
        }
        // In real system you'd have a price map - here we simulate
        double price = 35.0; // example price
        System.out.println("Item " + itemCode + " selected. Price: ₱" + price);
        machine.setSelectedItem(itemCode, price);
        machine.changeState(new ItemSelectedState());
    }

    @Override
    public void insertCoin(VendingMachine machine, double amount) {
        System.out.println("Please select an item first.");
    }

    @Override
    public void dispenseItem(VendingMachine machine) {
        System.out.println("No item selected yet.");
    }

    @Override
    public void setOutOfOrder(VendingMachine machine) {
        System.out.println("Machine is now OUT OF ORDER.");
        machine.changeState(new OutOfOrderState());
    }

    @Override
    public String toString() {
        return "Idle";
    }
}