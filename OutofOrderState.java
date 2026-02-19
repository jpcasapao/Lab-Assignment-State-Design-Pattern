class OutOfOrderState implements VendingMachineState {
    @Override
    public void selectItem(VendingMachine machine, String itemCode) {
        System.out.println("Machine is OUT OF ORDER.");
    }

    @Override
    public void insertCoin(VendingMachine machine, double amount) {
        System.out.println("Machine is OUT OF ORDER. Cannot accept coins.");
    }

    @Override
    public void dispenseItem(VendingMachine machine) {
        System.out.println("Machine is OUT OF ORDER.");
    }

    @Override
    public void setOutOfOrder(VendingMachine machine) {
        System.out.println("Machine is already OUT OF ORDER.");
    }

    @Override
    public String toString() {
        return "OutOfOrder";
    }
}