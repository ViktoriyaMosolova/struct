import operator

def f1(a, b):
    return 1 / (a + b)

def f2(a, b, s):
    ops = {
        '+': operator.add,
        '-': operator.sub,
        '*': operator.mul,
        '/': operator.truediv
    }
    return ops[s](a, b)

def inc(number):
    return number + 4.0

def fun(a, b, o, fun1, fun2, n):
    if n == 1:
        return fun1(a, b)
    else:
        return fun2(fun1(a, b), fun(inc(a), inc(b), o, fun1, fun2, n-1), o)

print(fun(1, 3, "/", f1, f2, 2))