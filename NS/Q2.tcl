set ns [new Simulator]
set tracefile [open out.tr w]
$ns trace-all $tracefile

set nf [open out.tr w]
$ns namtrace-all $nf

proc finish {} {
    global ns tracefile nf
    $ns flush-trace
    close $nf
    close $tracefile
    exec nam out.nam &
    exit
}

set n0 [$ns node]
set n1 [$ns node]

$ns duplex-link $n0 $n1 1Mb 10ms DropTail

set tcp0 [new Agent/TCP]
$ns attach-agent $n0 $tcp0
set cbr0 [new Application/Traffic/CBR]
$cbr0 attach-agent $tcp0

set tcpsink0 [new Agent/TCPSink]
$ns attach-agent $n1 $tcpsink0

$ns connect $tcp0 $tcpsink0

$ns at 1.0 "$cbr0 start"
$ns at 3.0 "finish"

$ns run 



















