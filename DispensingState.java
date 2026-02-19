class DispensingState implements VendingMachineState {
    @Override
    public void selectItem(VendingMachine machine, String itemCode) {
        // no-op
    }

    @Override
    public void insertCoin(VendingMachine machine, double amount) {
        // no-op
    }

    @Override
    public void dispenseItem(VendingMachine machine) {
        String item = machine.getSelectedItem();
        machine.decreaseInventory(item);
        System.out.println("→ Dispensing " + item + " ... Enjoy!");
        
        double change = machine.getBalance() - machine.getItemPrice();
        if (change > 0) {
            System.out.println("Change returned: ₱" + change);
        }
        
        // Clean up
        machine.resetBalance();
        machine.clearSelection();
        
        // Auto transition back to Idle
        machine.changeState(new IdleState());
    }

    @Override
    public void setOutOfOrder(VendingMachine machine) {
        // Usually not allowed during dispensing, but possible in emergency
        System.out.println("Machine is now OUT OF ORDER.");
        machine.changeState(new OutOfOrderState());
    }

    @Override
    public String toString() {
        return "Dispensing";
    }
}