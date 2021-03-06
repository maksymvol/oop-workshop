package checkout;

import java.time.LocalDate;

public class CheckoutService {

    private LocalDate currentDate;
    private Check check;

    public CheckoutService(LocalDate currentDate) {
        this.currentDate = currentDate;
    }

    public void openCheck() {
        check = new Check(currentDate);
    }

    public void addProduct(Product product) {
        if (check == null) {
            openCheck();
        }
        check.addProduct(product);
    }

    public Check closeCheck() {
        check.applyOffers();
        Check closedCheck = check;
        check = null;
        return closedCheck;
    }

    public void useOffer(Offer offer) {
        check.addOffer(offer);
    }
}
