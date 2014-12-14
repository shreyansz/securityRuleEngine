# Security Rule Engine
The engine will provide an interface to accept/reject any kind of [security] at a given date.

The engine will provide 3 rule implementations:
- Dividend Rule: reject [equity] that have dividend falling within a week, accept otherwise.
- Coupon Rule: reject [bond] that have coupon falling within a week, accept otherwise.
- Issuer Rule: Only accept security issued by a given [issuer].

### Version
1.0.0
### Implementation
 - Program accepts type of security by user and validates it
```
Enter selection number: 1. Equity 2. Bond
2
```
 - Program then accepts due date for dividend / coupon, validates it and checks whether due date is within the next 7 days of the current date. If yes, the security is rejected and the program terminates. This is the implementation of the dividend and coupon rule.
```
Enter next due date (YYYY-MM-DD) for coupon
2014-12-32
Invalid date, try again
2014-12-21
Security rejected.
```
 - At this stage, the program accepts the issuer name and checks it against a set of accepted issuers. The security is accepted only if the issuer an accepted one. This is the implementation of the Issuer rule.
```
Enter Issuer Name
issuerTest
Security Accepted!
```

### Technologies
The application is built using Java, JUnit and Eclipse IDE.  
### Future Scope
 - Coupon / dividend generation 
 - Enhanced UI

###License
MIT
[security]:http://www.investopedia.com/terms/s/security.asp
[equity]:http://www.investopedia.com/terms/e/equity.asp
[bond]:http://www.investopedia.com/terms/b/bond.asp
[issuer]:http://www.investopedia.com/terms/i/issuer.asp
