public class Main {
    public static void main(String[] args) {
        VendingMachine vm = new VendingMachine();

        vm.selectItem("A1");           // → ItemSelected
        vm.insertCoin(20.0);           // still needs more
        vm.insertCoin(20.0);           // → Dispensing → Idle
        System.out.println();

        vm.insertCoin(50.0);           // should say select item first
        vm.selectItem("A2");           // → ItemSelected
        vm.setOutOfOrder();            // → OutOfOrder
        vm.selectItem("A1");           // rejected
    }
}