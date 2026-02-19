class ItemSelectedState implements VendingMachineState {
    @Override
    public void selectItem(VendingMachine machine, String itemCode) {
        System.out.println("Item already selected. Please complete or cancel current selection.");
    }

    @Override
    public void insertCoin(VendingMachine machine, double amount) {
        if (amount <= 0) {
            System.out.println("Invalid coin amount.");
            return;
        }
        machine.addToBalance(amount);
        System.out.println("Inserted ₱" + amount + ". Current balance: ₱" + machine.getBalance());

        double price = machine.getItemPrice();
        if (machine.getBalance() >= price) {
            System.out.println("Enough payment received. Dispensing item...");
            machine.changeState(new DispensingState());
            machine.dispenseItem();  // trigger dispense immediately
        }
    }

    @Override
    public void dispenseItem(VendingMachine machine) {
        System.out.println("Please insert sufficient coins first.");
    }

    @Override
    public void setOutOfOrder(VendingMachine machine) {
        System.out.println("Machine is now OUT OF ORDER.");
        machine.changeState(new OutOfOrderState());
    }

    @Override
    public String toString() {
        return "ItemSelected";
    }
}